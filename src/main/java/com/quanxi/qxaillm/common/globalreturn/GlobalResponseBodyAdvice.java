package com.quanxi.qxaillm.common.globalreturn;

/**
 * Author: liYuXi
 * Date: 8/16/24
 * Time: 8:49 AM
 * Package:com.qx.common.GlobalExceptionHandler
 * Project:untitled
 * 功能：使用 @RestControllerAdvice 来拦截所有控制器的响应，并对其进行统一封装
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {


    private final ObjectMapper objectMapper;    // 处理 String 类型返回值

    public GlobalResponseBodyAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.hasMethodAnnotation(NotControllerResponseAdvice.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {


        // 处理 String 类型返回值
//        当控制器方法返回 String 类型时，在使用 @ResponseBodyAdvice 进行统一封装时，
//        可能会导致异常出现 500 Internal Server Error 的问题。这通常是由于 Spring 在处理
//        String 类型的返回值时，无法正确地将其转换为 JSON 响应格式引起的。
        //下面对 String 类型的返回值进行特殊处理，将其封装后再转换为 JSON 字符串返回。
        if (body instanceof String) {
            try {
                return objectMapper.writeValueAsString(ResponseApi.success(body));
            } catch (  JsonProcessingException e) {
                throw new HttpMessageConversionException("Failed to convert response to JSON");
            }
        }

        // 如果返回的是 ApiResponse 类型，直接返回
        if (body instanceof ResponseApi) {
            return body;
        }
        // 否则封装成 ApiResponse 类型
        return ResponseApi.success(body);
    }
}
