package com.lfool.jwt.util;

import com.lfool.jwt.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 00:55
 **/
@Component
public class JwtUtil {

    public static final Key key = Keys.hmacShaKeyFor("hiypibkrkrqyygycuuynrwojoexkgubtkprnxsaarfiznwluabsnwwexseizeecc".getBytes());
//    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public static String createJwtToken(User user) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setId("user")
                .claim("authorities", "all")
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 60 * 60 * 60 * 1000))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
