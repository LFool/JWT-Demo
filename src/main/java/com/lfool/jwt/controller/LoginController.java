package com.lfool.jwt.controller;

import com.lfool.jwt.annotation.NeedToken;
import com.lfool.jwt.annotation.PassToken;
import com.lfool.jwt.entity.User;
import com.lfool.jwt.response.CommonReturnType;
import com.lfool.jwt.service.UserService;
import com.lfool.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/9 06:01
 **/
@RestController
@RequestMapping("/acc")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonReturnType login(@RequestBody User user) {
        User queryUser = userService.findUserById(user.getId());
        if (queryUser == null) {
            return CommonReturnType.create("用户不存在，请重新登陆！", "fail");
        }
        if (!queryUser.getPassword().equals(user.getPassword())) {
            return CommonReturnType.create("密码错误，请重新登陆！", "fail");
        }
        String token = JwtUtil.createJwtToken(user);
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        return CommonReturnType.create(response);
    }

    @NeedToken
    @GetMapping("/getMessage")
    public CommonReturnType getMessage() {
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "hhhh");
        return CommonReturnType.create(response);
    }

    @PassToken
    @GetMapping("/get")
    public CommonReturnType get() {
        Map<String, Object> response = new HashMap<>();
        response.put("msg", "wwwww");
        return CommonReturnType.create(response);
    }
}
