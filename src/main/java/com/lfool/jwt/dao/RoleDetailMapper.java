package com.lfool.jwt.dao;

import com.lfool.jwt.entity.RoleDetail;

import java.util.List;

public interface RoleDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleDetail record);

    int insertSelective(RoleDetail record);

    RoleDetail selectByPrimaryKey(Integer id);

    List<RoleDetail> selectByRoleId(Integer roleId);

    int updateByPrimaryKeySelective(RoleDetail record);

    int updateByPrimaryKey(RoleDetail record);
}