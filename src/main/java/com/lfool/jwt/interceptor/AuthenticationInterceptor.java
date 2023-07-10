package com.lfool.jwt.interceptor;

import com.lfool.jwt.annotation.NeedToken;
import com.lfool.jwt.annotation.PassToken;
import com.lfool.jwt.entity.User;
import com.lfool.jwt.exception.EmError;
import com.lfool.jwt.exception.MyException;
import com.lfool.jwt.service.UserService;
import com.lfool.jwt.util.JwtUtil;
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
        String token = request.getHeader("Authorization");
        token = token.split(" ")[1];
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
                if (token == null) {
                    throw new MyException(EmError.TOKEN_NOT_EXIST);
                }
                Integer userId;
                try {
                    Claims claims = Jwts.parserBuilder().setSigningKey(JwtUtil.key).build().parseClaimsJws(token).getBody();
                    userId = Integer.parseInt(claims.getSubject());
                } catch (Exception e) {
                    throw new MyException(EmError.TOKEN_PARSER_FAIL);
                }
                User user = userService.findUserById(userId);
                if (user == null) {
                    throw new MyException(EmError.USER_NOT_EXIST);
                }
                return true;
            }
        }
        return true;
    }
}
