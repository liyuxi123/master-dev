package com.quanxi.qxaillm.common.globalreturn;

import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * Author: liYuXi
 * Date: 8/16/24
 * Time: 8:48 AM
 * Package:com.qx.common.GlobalExceptionHandler
 * Project:untitled
 * 功能：自定义异常枚举，根据业务从1000+
 */
@Getter
public enum ExceptionEnum {

    SQL_ID_IS_NULL(1001, "sql失败:指标编号不存在"),
    SQL_IS_NOT_TEST(1002, "sql失败:指标未进行编译(在qxzsk_t_indicator_sql表中null/未调试/失败/)"),
    SQL_IS_NUll(1003, "sql失败:指标的sql为空"),
    SQL_OVER_TIME_60S(1004,"sql超时:不得超过60秒 请优化"),

    ERROR_ziasdhfjk(1005,"adsjfhkjasfhd"),

    //常用http自带状态码 参考org.springframework.http.HttpStatus 或者 cn.hutool.http.HttpStatus
    NOT_FOUND(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());

    private int  code;
    private String msg;
    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
