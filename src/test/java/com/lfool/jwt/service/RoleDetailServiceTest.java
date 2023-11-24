package com.lfool.jwt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleDetailServiceTest {

    @Autowired
    private RoleDetailService roleDetailService;

    @Test
    void testGetUrlByRoleId() {
        Set<String> urls = roleDetailService.getUrlByRoleId(1);
        System.out.println(urls);
    }
}