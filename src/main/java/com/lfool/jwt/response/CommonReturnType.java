package com.lfool.jwt.response;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 02:36
 **/
@Data
public class CommonReturnType {

    private String status;

    private Object data;

    public static CommonReturnType create(Object result) {
        return CommonReturnType.create(result, "success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }
}
