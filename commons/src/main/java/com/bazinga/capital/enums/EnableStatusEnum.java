package com.bazinga.capital.enums;

/**
 * @author yunshan
 * @date 2019/1/6
 */
public enum EnableStatusEnum {
    ENABLE(0,"允许"),
    DISABLE(1,"禁止");

    private Integer code;

    private String desc;

    EnableStatusEnum(Integer code, String desc) {
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
