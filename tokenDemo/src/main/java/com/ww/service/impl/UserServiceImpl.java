package com.ww.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ww.domain.entity.User;
import com.ww.mapper.UserMapper;
import com.ww.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-01-14 20:27:48
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
