package com.mao.softwaredesigner1227.exception;

import com.mao.softwaredesigner1227.entity.Result;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();
        Result error = null;
        if (e.getMessage().equals("")){
            error = Result.error(e.getMessage());
        }else {
            error = Result.error("操作失败");
        }
        return error;
    }
}
