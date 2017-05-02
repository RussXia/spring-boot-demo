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
     * 
     * demo_user.cert_no
     */
    private String certNo;

    /**
     * 
     * demo_user.password
     */
    private String password;

    /**
     * 性别 0 男 1 女
     * demo_user.sex
     */
    private Integer sex;

    /**
     * 个人信息验证状态（0为未完善，10为待验证，15为驳回，20为验证通过）
     * demo_user.is_verify
     */
    private Integer isVerify;

    /**
     * 是否物流删除: 1-已删除, 0-未删除
     * demo_user.is_deleted
     */
    private Integer isDeleted;

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