package com.lfool.jwt.util;

import com.lfool.jwt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Key;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JwtUtilTest {

    @Test
    public void test() {
        User user = new User(1, "zs", "123456");

        // 创建 jwt
        String token = JwtUtil.createJwtToken(user);
        System.out.println(token);

        // 解析
        Claims claims = Jwts.parserBuilder().setSigningKey(JwtUtil.key).build().parseClaimsJws(token).getBody();

        assertEquals(user.getId().toString(), claims.getSubject());
    }

}