package com.lfool.jwt.exception;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 02:14
 **/
public class MyException extends Exception implements CommonError {

    private final CommonError commonError;

    public MyException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    public MyException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return commonError.getErrMsg();
    }

    @Override
    public void setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
    }
}
