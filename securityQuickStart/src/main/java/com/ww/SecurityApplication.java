package com.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Author: ww
 * DateTime: 2023/1/14 15:28
 */
@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SecurityApplication.class, args);
        System.out.println(1);
    }
}
