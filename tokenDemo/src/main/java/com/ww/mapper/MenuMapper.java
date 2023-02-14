package com.ww.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ww.domain.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Author: ww
 * DateTime: 2023/2/14 19:24
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户id查询其权限信息
     * @param id
     * @return
     */
    List<String> selectPermsByUserId(Long id);
}
