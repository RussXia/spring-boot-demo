package com.xzy.demo.result;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    SUCCESS("0000", "成功"),
    NO_DATA("1002", "无数据"),
    PARAM_ERROR("1003", "参数错误"),
    INSERT_FAIL("1004", "插入数据错误"),
    QUERY_FAIL("1005", "查询错误"),
    UPDATE_FAIL("1006", "修改数据错误"),
    DATA_ERROR("1008", "数据异常"),
    DUPLICATE_ERROR("1009", "重复操作"),
    UPLOAD_ERROR("1010", "文件上传失败"),
    NO_AUTH("1011", "无操作权限"),
    NO_ADMIN_USER("1012", "无该用户信息"),
    NO_ADMIN_ROLE("1013", "无角色信息"),
    NO_ROLE_FUNCTION("1014", "无角色功能点信息"),

    EXCEPTION("9999", "系统异常");


    private String errCode;

    private String errMsg;
}
