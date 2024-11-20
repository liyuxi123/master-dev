package com.quanxi.qxaillm.common.globalreturn;

import lombok.Getter;

/**
 * Author: liYuXi
 * Date: 8/16/24
 * Time: 10:30 AM
 * Package:com.qx.common.GlobalExceptionHandler
 * Project:untitled
 * 功能：自定义异常类
 */

@Getter
public class ExceptionCustom extends RuntimeException   {
    private int code;   // 状态码
    private String msg;  // 状态码配套的msg
    private Object data;   //返回的数据

    //  自定义异常
    public ExceptionCustom(int code, String msg, Object data){
        this.code =code;
        this.msg = msg;
        this.data=data;
    }

}
