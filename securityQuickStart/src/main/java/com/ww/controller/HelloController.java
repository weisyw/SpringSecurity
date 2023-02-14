package com.ww.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ww
 * DateTime: 2023/1/14 15:28
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/test")
    public String test(){
        log.info("running...");
        return "running...";
    }
}
