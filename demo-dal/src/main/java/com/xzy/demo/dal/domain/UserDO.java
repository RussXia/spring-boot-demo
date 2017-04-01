package com.xzy.demo.dal.domain;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * demo_user.user_id
     */
    private Long userId;

    /**
     * 登陆名（注册手机号）
     * demo_user.login_name
     */
    private String loginName;

    /**
     * 密码
     * demo_user.password
     */
    private String password;

}