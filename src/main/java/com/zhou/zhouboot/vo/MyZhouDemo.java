package com.zhou.zhouboot.vo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhougq
 **/
@SpringBootApplication
@MapperScan("com.zhou.zhouboot.mapper.*")
public class MyZhouDemo {
    public static void main(String[] args) {
        SpringApplication.run(MyZhouDemo.class, args);
    }
}
