package com.ww;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: ww
 * DateTime: 2023/1/14 20:03
 */
@SpringBootApplication
@MapperScan("com.ww.mapper")
public class TokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(TokenApplication.class, args);
    }
}
