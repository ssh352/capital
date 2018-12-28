package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈买一买一信息 查询参数〉<p>
 *
 * @author
 * @date 2018-12-28
 */
@lombok.Data
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.ToString(callSuper = true)
public class DepthMarketDataExQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 卖一队列的有效委托笔数
     */
    private Integer ask1Count;

    /**
     * 卖一队列数据
     */
    private String ask1Qty;

    /**
     * 买一队列的有效委托笔数
     */
    private Integer bid1Count;

    /**
     * 买一队列数据
     */
    private String bid1Qty;

    /**
     * 卖一队列总委托笔数
     */
    private Integer maxAsk1Count;

    /**
     * 买一队列总委托笔数
     */
    private Integer maxBid1Count;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;

}