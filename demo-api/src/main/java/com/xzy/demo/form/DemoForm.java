package com.xzy.demo.form;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoForm implements Serializable {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 企业Id
     */
    private Long partnerId;

    /**
     * 品牌Id
     */
    private Long brandId;

    /**
     * 状态
     */
    private Integer status;
}
