package com.bazinga.capital.enums;

/**
 * @author yunshan
 * @date 2019/1/9
 */
public enum OperateTypeEnum {
    SYSTEM_AUTO(1,"系统自动化"),
    MANUAL(2,"人工操作");

    private Integer code;

    private String desc;

    OperateTypeEnum(Integer code, String desc) {
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
