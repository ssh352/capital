package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈逐笔委托 查询参数〉<p>
 *
 * @author
 * @date 2018-12-22
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class TickByTickQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 委托时间
     */
    private String datetime;

    /**
     * 预留
     */
    private Long seq;

    /**
     * 合约代码
     */
    private String ticker;

    /**
     * 逐笔委托id
     */
    private Long entrustId;

    /**
     * 交易所代码
     */
    private Integer exchangeType;

    /**
     * 逐笔成交id
     */
    private Long tradeId;

    /**
     * 委托 or 成交
     */
    private Integer type;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;


}