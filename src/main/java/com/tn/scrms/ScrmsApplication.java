package com.tn.scrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.tn.scrms.*")
//package org.mybatis.spring.annotation;
//@MapperScan(basePackages = "com.tn.scrms.dao", sqlSessionTemplateRef = "sqlSessionTemplate")
//@MapperScan(basePackages = "com.tn.scrms.dao", sqlSessionTemplateRef = "sqlSessionTemplate")
public class ScrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrmsApplication.class, args);
    }

}
