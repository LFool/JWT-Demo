package com.lfool.jwt.exception;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 02:15
 **/
public interface CommonError {

    int getErrCode();

    String getErrMsg();

    void setErrMsg(String errMsg);
}
