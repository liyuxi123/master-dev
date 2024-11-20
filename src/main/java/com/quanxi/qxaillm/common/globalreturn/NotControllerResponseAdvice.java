package com.quanxi.qxaillm.common.globalreturn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: liYuXi
 * Date: 8/16/24
 * Time: 9:52 AM
 * Package:com.qx.common.GlobalExceptionHandler
 * Project:untitled
 * 功能：不使用全局封装返回结果
 * 注解@NotControllerResponseAdvice
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public  @interface NotControllerResponseAdvice {
}