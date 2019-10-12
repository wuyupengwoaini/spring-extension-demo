package com.demo.imports.dao;

import com.demo.imports.annotation.Mapper;
import com.demo.imports.annotation.Select;

/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 16:48
 **/
@Mapper
public interface UserDaoMapper {
    /**
     * 模拟获取用户名称
     * @return
     */
    @Select("select name from user where id = 1")
    String getUserName();
}
