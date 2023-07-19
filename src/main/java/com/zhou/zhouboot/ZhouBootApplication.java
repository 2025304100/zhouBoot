package com.zhou.zhouboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhou.zhouboot.mapper")
//@MapperScan("com.zhou.zhouboot.mapper.*
public class ZhouBootApplication {

    public static void main(String[] args) {
//        SpringApplication.exit(SpringApplication.run(ZhouBootApplication.class, args));
        SpringApplication.run(ZhouBootApplication.class, args);
    }

}
