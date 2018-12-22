package com.bazinga.capital.model;

import lombok.Data;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈逐笔委托〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@Data
public class TickByTick implements Serializable {

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
     * 委托时间
     *
     * @最大长度   16777215
     * @允许为空   NO
     * @是否索引   NO
     */
    private String datetime;

    /**
     * 预留
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long seq;

    /**
     * 合约代码
     *
     * @最大长度   16
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticker;

    /**
     * 逐笔委托id
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long entrustId;

    /**
     * 交易所代码
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer exchangeType;

    /**
     * 逐笔成交id
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Long tradeId;

    /**
     * 委托 or 成交
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer type;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;


}