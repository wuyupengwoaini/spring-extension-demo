package com.demo.imports.service;

import com.demo.imports.dao.UserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
/**
 * @Description
 * @Author wuyupeng
 * @Date 2019/10/11 16:30
 **/
@ConditionalOnBean(BizService.class)
public class UserService {

    @Autowired
    private UserDaoMapper userDaoMapper;

    public String getUserName(){
        return userDaoMapper.getUserName();
    }

}
