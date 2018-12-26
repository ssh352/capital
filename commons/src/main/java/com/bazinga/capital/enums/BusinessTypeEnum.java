package com.bazinga.capital.enums;

/**
 * @author yunshan
 * @date 2018/12/26
 */
public enum BusinessTypeEnum {

    XTP_BUSINESS_TYPE_CASH(1,""),
    XTP_BUSINESS_TYPE_IPOS(2,""),
    XTP_BUSINESS_TYPE_REPO(3,""),
    XTP_BUSINESS_TYPE_ETF(4,""),
    XTP_BUSINESS_TYPE_MARGIN(5,""),
    XTP_BUSINESS_TYPE_DESIGNATION(6,""),
    XTP_BUSINESS_TYPE_ALLOTMENT(7,""),
    XTP_BUSINESS_TYPE_STRUCTURED_FUND_PURCHASE_REDEMPTION(8,""),
    XTP_BUSINESS_TYPE_STRUCTURED_FUND_SPLIT_MERGE(9,""),
    XTP_BUSINESS_TYPE_MONEY_FUND(10,""),
    XTP_BUSINESS_TYPE_OPTION(11,""),
    XTP_BUSINESS_TYPE_EXECUTE(12,""),
    XTP_BUSINESS_TYPE_FREEZE(13,""),
    XTP_BUSINESS_TYPE_UNKNOWN(14,"");

    private Integer code;

    private String desc;

    BusinessTypeEnum(Integer code, String desc) {
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
