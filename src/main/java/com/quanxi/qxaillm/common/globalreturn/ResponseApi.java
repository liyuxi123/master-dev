package com.quanxi.qxaillm.common.globalreturn;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Author: liYuXi
 * Date: 8/16/24
 * Time: 8:41 AM
 * Package:com.qx.common.GlobalExceptionHandler
 * Project:untitled
 * 功能：定义一个通用的响应类，用来封装所有的 API 响应结果：
 */
@Data
public class ResponseApi<T> {
    private int code;
    private String message;
    private T data;

    // 构造函数
    public ResponseApi(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 静态方法用于成功返回
    public static <T> ResponseApi<T> success(T data) {
        return new ResponseApi<>(HttpStatus.OK.value(), "success", data);
    }

    // 静态方法用于错误返回
    public static <T> ResponseApi<T> error(int code, String message) {
        return new ResponseApi<>(code, message, null);
    }


}



