package com.bazinga.capital.enums;

public enum OrderStatusTypeEnum {
    XTP_ORDER_STATUS_INIT(1, ""),
    XTP_ORDER_STATUS_ALLTRADED(2, ""),
    XTP_ORDER_STATUS_PARTTRADEDQUEUEING(3, ""),
    XTP_ORDER_STATUS_PARTTRADEDNOTQUEUEING(4, ""),
    XTP_ORDER_STATUS_NOTRADEQUEUEING(5, ""),
    XTP_ORDER_STATUS_CANCELED(6, ""),
    XTP_ORDER_STATUS_REJECTED(7, ""),
    XTP_ORDER_STATUS_UNKNOWN(8, "");


    private Integer code;

    private String desc;

    OrderStatusTypeEnum(Integer code, String desc) {
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
