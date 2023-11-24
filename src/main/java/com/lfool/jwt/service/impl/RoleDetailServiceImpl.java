package com.lfool.jwt.service.impl;

import com.lfool.jwt.dao.RoleDetailMapper;
import com.lfool.jwt.dao.RoleMapper;
import com.lfool.jwt.entity.RoleDetail;
import com.lfool.jwt.service.RoleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/11/25 00:13
 **/
@Service
public class RoleDetailServiceImpl implements RoleDetailService {

    @Autowired
    private RoleDetailMapper roleDetailMapper;

    @Override
    public Set<String> getUrlByRoleId(Integer roleId) {
        List<RoleDetail> roleDetailList = roleDetailMapper.selectByRoleId(roleId);
        Set<String> urls = new HashSet<>();
        for (RoleDetail roleDetail : roleDetailList) {
            urls.add(roleDetail.getUrl());
        }
        return urls;
    }
}
