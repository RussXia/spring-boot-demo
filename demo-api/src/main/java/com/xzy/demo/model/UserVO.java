package com.xzy.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by RuzzZZ on 2017/4/20.
 */
@Data
public class UserVO implements Serializable {

    private Long userId;

    private String loginName;

    private String password;

    private Date gmtCreate;

    private Date gmtModified;
}
