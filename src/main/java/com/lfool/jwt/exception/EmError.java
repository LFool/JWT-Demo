package com.lfool.jwt.exception;

import lombok.AllArgsConstructor;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 02:27
 **/

@AllArgsConstructor
public enum EmError implements CommonError{

    TOKEN_NOT_EXIST(10001, "token 不存在，请重新登陆"),
    TOKEN_PARSER_FAIL(10002, "token 解析异常，请重新登陆"),
    USER_NOT_EXIST(10003, "用户不存在，请重新登陆"),
    UNKNOWN_ERROR(10004, "未知错误"),
    ;

    private final int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
