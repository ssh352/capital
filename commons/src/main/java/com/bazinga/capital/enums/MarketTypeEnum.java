package com.bazinga.capital.enums;

/**
 * @author yunshan
 * @date 2018/12/26
 */
public enum MarketTypeEnum {

    XTP_MKT_INIT(0,""),
    XTP_MKT_SZ_A(1,""),
    XTP_MKT_SH_A(2,""),
    XTP_MKT_UNKNOWN(3,"");

    private Integer code;

    private String desc;

    MarketTypeEnum(Integer code, String desc) {
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
