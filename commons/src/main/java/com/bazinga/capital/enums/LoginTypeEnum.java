package com.bazinga.capital.enums;

public enum LoginTypeEnum {
    QUOTE(1, "行情登录"),
    TRADE(2, "交易登录");

    private Integer code;

    private String desc;

    LoginTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
