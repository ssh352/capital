package com.bazinga.capital.model;

import java.util.Date;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈禁止操作池〉<p>
 *
 * @author
 * @date 2019-01-12
 */
@lombok.Data
@lombok.ToString
public class DisableOperateTicketPool implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Long id;

    /**
     * 股票代码
     *
     * @最大长度   10
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   uk_ticker_day
     */
    private String ticker;

    /**
     * 
     *
     * @最大长度   30
     * @允许为空   YES
     * @是否索引   NO
     */
    private String tickerName;

    /**
     * 日期显示 格式 yyyy-MM-dd
     *
     * @最大长度   15
     * @允许为空   YES
     * @是否索引   NO
     */
    private String day;

    /**
     * 0 系统操作 1 人工操作
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer operateStatus;

    /**
     * 2 进制标识 11 禁止下单 禁止撤单, 10 禁止下单,01 禁止撤单 00 都不禁止
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer businessStatus;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Date updateTime;

    /**
     *  添加一项禁用业务类型
     */
    public void enableBusiness(int businessStatus) {
        this.businessStatus |= businessStatus;
    }


    /**
     *  删除一项禁用业务类型
     */
    public void disableBusiness(int businessStatus) {
        this.businessStatus ^= businessStatus;
    }

    /**
     *  是否拥某些禁用业务类型
     */
    public boolean isAllowBusiness(int businessStatus) {
        return (this.businessStatus & businessStatus) == businessStatus;
    }

    /**
     *  添加一项禁用业务类型
     */
    public void enableOperate(int operateStatus) {
        this.operateStatus |= operateStatus;
    }


    /**
     *  删除一项禁用业务类型
     */
    public void disableOperate(int operateStatus) {
        this.operateStatus ^= operateStatus;
    }

    /**
     *  是否拥某些禁用业务类型
     */
    public boolean isAllowOperate(int operateStatus) {
        return (this.operateStatus & operateStatus) == operateStatus;
    }
}