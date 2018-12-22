package com.bazinga.capital.enums;

public enum ApiResponseEnum {
    TICKET_INFO_RESPONSE("ticketInfoResponse","股票信息响应信息"),
    DEPTH_MARKET_DATA_RESPONSE("DepthMarketDataResponse","深度行情");
    private String code ;

    private String desc;

    ApiResponseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
