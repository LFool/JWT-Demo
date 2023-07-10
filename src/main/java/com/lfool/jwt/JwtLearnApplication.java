package com.lfool.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lfool.jwt"})
@MapperScan("com.lfool.jwt.dao")
public class JwtLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtLearnApplication.class, args);
    }

}
