package com.xzy.demo.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    NORMAL(1, "正常状态"),
    DISABLED(0, "禁用状态");

    private int code;
    private String desc;

    public static StatusEnum getByCode(int code) {
        for (StatusEnum attr : StatusEnum.values()) {
            if (code == attr.getCode()) {
                return attr;
            }
        }
        throw new IllegalArgumentException("No access code.");
    }

    public static StatusEnum getByDesc(String desc) {
        if (desc == null || desc.length() == 0) {
            throw new RuntimeException("Desc is empty.");
        }
        for (StatusEnum attr : StatusEnum.values()) {
            if (desc.equals(attr.getDesc())) {
                return attr;
            }
        }
        throw new IllegalArgumentException("No access desc.");
    }
}
