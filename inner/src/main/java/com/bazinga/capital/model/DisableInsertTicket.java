package com.bazinga.capital.model;

import java.util.Date;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈DisableInsertTicket〉<p>
 *
 * @author
 * @date 2019-01-09
 */
@lombok.Data
@lombok.ToString
public class DisableInsertTicket implements Serializable {

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
     * 股票名称
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
    private Integer operateType;

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


}