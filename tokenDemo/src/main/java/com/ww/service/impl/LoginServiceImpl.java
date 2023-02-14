package com.ww.service.impl;

import com.ww.domain.ResponseResult;
import com.ww.domain.entity.LoginUser;
import com.ww.domain.entity.User;
import com.ww.service.LoginServcie;
import com.ww.utils.JwtUtil;
import com.ww.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

import static com.ww.constant.SysConstant.LOGIN;

/**
 * Author: ww
 * DateTime: 2023/1/15 14:59
 */

@Service
public class LoginServiceImpl implements LoginServcie {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;



    @Override
    public ResponseResult login(User user) {
        // 1. AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 2. 如果认证吗通过，给出对应提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        // 3. 如果认证通过了，使用 userId 生成一个 jwt 存入 ResponseResult 返回
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        // 4. 把完整的用户信息存入 redis, userId 作为 key
        redisCache.setCacheObject(LOGIN + userId, loginUser);
        HashMap<String,String> map = new HashMap<>();
        map.put("token", jwt);
        return new ResponseResult<>(200, "登录成功", map);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUser().getId();
        redisCache.deleteObject(LOGIN + userid);
        return new ResponseResult(200,"退出成功");
    }

}
