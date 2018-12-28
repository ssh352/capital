package com.bazinga.capital.model;

import java.util.Date;

import java.io.Serializable;

/**
 * 〈买一买一信息〉<p>
 *
 * @author
 * @date 2018-12-28
 */
@lombok.Data
@lombok.ToString
public class DepthMarketDataEx implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Long id;

    /**
     * 卖一队列的有效委托笔数
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer ask1Count;

    /**
     * 卖一队列数据
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ask1Qty;

    /**
     * 买一队列的有效委托笔数
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer bid1Count;

    /**
     * 买一队列数据
     *
     * @最大长度   255
     * @允许为空   NO
     * @是否索引   NO
     */
    private String bid1Qty;

    /**
     * 卖一队列总委托笔数
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer maxAsk1Count;

    /**
     * 买一队列总委托笔数
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer maxBid1Count;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date createTime;


}