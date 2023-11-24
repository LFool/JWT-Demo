package com.lfool.jwt.service;

import com.lfool.jwt.entity.RoleDetail;

import java.util.List;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/11/25 00:07
 **/
public interface RoleDetailService {
    Set<String> getUrlByRoleId(Integer roleId);
}
