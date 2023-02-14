package com.ww.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ww.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-14 20:27:44
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
