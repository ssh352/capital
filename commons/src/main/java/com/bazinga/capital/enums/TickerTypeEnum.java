package com.bazinga.capital.enums;

/**
 * 按股数划分股票类型
 *
 * @author yunshan
 * @date 2019/1/6
 */
public enum TickerTypeEnum {
    MIN(0, "1亿以下"),
    MEDIUM(1, "1到3亿"),
    LARGE(2, "3到8亿"),
    HUGE(4, "8亿以上");

    private Integer code;

    private String desc;

    TickerTypeEnum(Integer code, String desc) {
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
