package com.lfool.jwt.interceptor;

import com.lfool.jwt.annotation.NeedToken;
import com.lfool.jwt.annotation.PassToken;
import com.lfool.jwt.entity.User;
import com.lfool.jwt.exception.EmError;
import com.lfool.jwt.exception.MyException;
import com.lfool.jwt.service.UserService;
import com.lfool.jwt.util.JwtUtil;
import com.lfool.jwt.util.RoleUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 01:47
 **/
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截的不是方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 拦截的方法上有 PassToken 注解，且 required = true，直接通过
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 拦截的方法上有 NeedToken 注解，且 required = true，需要判断 token
        if (method.isAnnotationPresent(NeedToken.class)) {
            NeedToken needToken = method.getAnnotation(NeedToken.class);
            if (needToken.required()) {
                String token = request.getHeader("Authorization");
                if (token == null) {
                    throw new MyException(EmError.TOKEN_NOT_EXIST);
                }
                // 格式：Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJ1c2VyIiwiYXV0aG9yaXRpZXMiOjEsInN1YiI6IjEiLCJpYXQiOjE2OTA1NjM2NDMsImV4cCI6MTY5MDc3OTY0M30.CrmmdvDeltMGYgfQnlN-dsTjmks9mhGckVHgXKcIXeZK9Epi6KitBhCSB3O4oj4P3qDci_AnXq6VjeHrA5ZMbw
                token = token.split(" ")[1];
                Integer userId, role;
                try {
                    Claims claims = Jwts.parserBuilder().setSigningKey(JwtUtil.key).build().parseClaimsJws(token).getBody();
                    userId = Integer.parseInt(claims.getSubject());
                    role = (Integer) claims.get("authorities");  // 获取权限
                } catch (Exception e) {
                    throw new MyException(EmError.TOKEN_PARSER_FAIL);
                }
                User user = userService.findUserById(userId);
                if (user == null) {
                    throw new MyException(EmError.USER_NOT_EXIST);
                }
                // 验证权限
                // 1 -> root; 2 -> manager; 3 -> user
                // NeedToken 注解的 role 字段表示方法允许访问的权限
                if (RoleUtil.getRole(needToken.role()) < role) {
                    throw new MyException(EmError.ROLE_NOT_ENOUGH);
                }
                return true;
            }
        }
        return true;
    }
}
