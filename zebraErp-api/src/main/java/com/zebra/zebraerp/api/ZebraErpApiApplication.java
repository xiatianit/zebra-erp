/**
 * Copyright (c) 2015, 59store. All rights reserved.
 */
package com.zebra.zebraerp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 斑马erp controller
 * @author owen
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.zebra" })
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
public class ZebraErpApiApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ZebraErpApiApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(ZebraErpApiApplication.class, args);
    }
}
