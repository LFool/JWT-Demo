package com.lfool.jwt.exception;

import com.lfool.jwt.response.CommonReturnType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 03:20
 **/
@ControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonReturnType doError(Exception exception) {
        exception.printStackTrace();
        Map<String, Object> response = new HashMap<>();
        String errCode = "errCode";
        String errMsg = "errMsg";
        if (exception instanceof MyException) {
            MyException myException = (MyException) exception;
            response.put(errCode, myException.getErrCode());
            response.put(errMsg, myException.getErrMsg());
        } else {
            response.put(errCode, EmError.UNKNOWN_ERROR.getErrCode());
            response.put(errMsg, EmError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonReturnType.create(response, "fail");
    }
}
