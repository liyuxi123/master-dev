package com.quanxi.qxaillm.common.globalreturn; /**
Author: liYuXi
Date: 8/16/24
Time: 8:47 AM
Package:com.qx.common.GlobalExceptionHandler
Project:untitled
功能：通过 @RestControllerAdvice 来捕获并处理全局异常，同时封装返回的错误响应：
     1、捕获自定义异常并封装返回结果
     2、捕获非自定义异常并封装返回结果（业界通用异常码详见org.springframework.http.HttpStatus）
*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // 捕获自定义异常并封装返回结果
    @ExceptionHandler(ExceptionCustom.class)
    public ResponseApi handleNotFoundException(ExceptionCustom customException) {
        return new ResponseApi(customException.getCode(),customException.getMsg(),customException.getData());
    }

    // 捕获非自定义异常并封装返回结果（业界通用异常码详见org.springframework.http.HttpStatus）
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseApi<Object>> handleGeneralException(Exception ex) {

        return new ResponseEntity<>(ResponseApi.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //



}
