package com.xzy.demo.dal.domain;

import java.io.Serializable;
import java.util.Date;

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

    /**
     * 创建时间
     * demo_user.gmt_create
     */
    private Date gmtCreate;

    /**
     * 修改时间
     * demo_user.gmt_modified
     */
    private Date gmtModified;

}