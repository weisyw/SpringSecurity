package com.ww.service;

import com.ww.domain.ResponseResult;
import com.ww.domain.entity.User;

/**
 * Author: ww
 * DateTime: 2023/1/15 14:22
 */
public interface LoginServcie {
    ResponseResult login(User user);

    ResponseResult logout();
}
