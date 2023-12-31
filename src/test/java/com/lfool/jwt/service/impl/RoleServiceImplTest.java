package com.lfool.jwt.service.impl;

import com.lfool.jwt.entity.Role;
import com.lfool.jwt.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void test() {
        Role role = roleService.getRoleByUserId(1);
        System.out.println(role);
    }
}