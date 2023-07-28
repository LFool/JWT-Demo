package com.lfool.jwt.util;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/29 00:55
 **/
public class RoleUtil {
    public static int getRole(String role) {
        if (role.equals("root")) return 1;
        if (role.equals("manager")) return 2;
        return 3;
    }
}
