package com.lfool.jwt.dao;

import com.lfool.jwt.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    void testSelectByPrimaryKey() {
        Role role = roleMapper.selectByPrimaryKey(1);
        System.out.println(role);
    }
}