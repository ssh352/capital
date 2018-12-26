package com.bazinga.capital.enums;

public enum PositionEffectTypeEnum {
    XTP_POSITION_EFFECT_INIT(1,""),
    XTP_POSITION_EFFECT_OPEN(2,""),
    XTP_POSITION_EFFECT_CLOSE(3,""),
    XTP_POSITION_EFFECT_FORCECLOSE(4,""),
    XTP_POSITION_EFFECT_CLOSETODAY(5,""),
    XTP_POSITION_EFFECT_CLOSEYESTERDAY(6,""),
    XTP_POSITION_EFFECT_FORCEOFF(7,""),
    XTP_POSITION_EFFECT_LOCALFORCECLOSE(8,""),
    XTP_POSITION_EFFECT_UNKNOWN(9,"");

    private Integer code;

    private String desc;

    PositionEffectTypeEnum(Integer code, String desc) {
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
