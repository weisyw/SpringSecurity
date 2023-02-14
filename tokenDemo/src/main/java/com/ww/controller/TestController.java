package com.ww.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: ww
 * DateTime: 2023/1/14 20:04
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public String test(){
        log.info("hello world");
        return "hello world";
    }
}
