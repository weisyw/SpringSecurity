package com.ww.controller;

import com.ww.domain.ResponseResult;
import com.ww.domain.entity.User;
import com.ww.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }


    @GetMapping("/user/logout")
    public ResponseResult logout(){
        return loginServcie.logout();
    }

}