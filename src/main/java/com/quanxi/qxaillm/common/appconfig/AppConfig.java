package com.quanxi.qxaillm.common.appconfig;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author: liYuXi
 * Date: 9/3/24
 * Time: 7:20 AM
 * Package:com.qx.common.appconfig
 * Project:untitled
 * 功能：读取yml文件一些自定义配置
 */


@Getter
@Component
public class AppConfig {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${app.dataSource.QXZSK}")
    private String dataSourceQXZSK;

    @Value("${app.dataSource.ODS}")
    private String dataSourceODS;

    @Value("${app.dataSource.DW}")
    private String dataSourceDW;

    @Value("${app.dataSource.DM}")
    private String dataSourceDM;



}