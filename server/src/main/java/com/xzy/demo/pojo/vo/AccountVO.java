package com.xzy.demo.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiazhengyue
 * @since 2021-01-04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountVO implements Serializable {
    private static final long serialVersionUID = 7823788303369051586L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 地址
     */
    private String address;

    /**
     * 积分
     */
    private BigDecimal score;

    /**
     * 性别:0-女性;1-男性
     */
    private Integer sex;

    /**
     * 注册时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;
}
