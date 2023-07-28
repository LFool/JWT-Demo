package com.lfool.jwt.dao;

import com.lfool.jwt.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    Role selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}