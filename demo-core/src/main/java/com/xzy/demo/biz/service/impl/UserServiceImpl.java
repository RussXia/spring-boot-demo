package com.xzy.demo.biz.service.impl;

import com.xzy.demo.biz.service.UserService;
import com.xzy.demo.dal.domain.UserDO;
import com.xzy.demo.dal.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RuzzZZ on 2017/4/1.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public boolean addUser() {
        UserDO userDO = new UserDO();
        userDO.setLoginName("xia");
        userDO.setPassword("123456");
        userManager.insertSelective(userDO);
        return true;
    }
}
