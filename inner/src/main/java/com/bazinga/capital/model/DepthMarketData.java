package com.bazinga.capital.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈DepthMarketData〉<p>
 *
 * @author
 * @date 2018-12-27
 */
@Data
public class DepthMarketData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @允许为空   NO
     * @是否索引   YES
     * @唯一索引   PRIMARY
     */
    private Long id;

    /**
     * 10档申卖价
     *
     * @最大长度   100
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ask;

    /**
     * 十档申卖量
     *
     * @最大长度   100
     * @允许为空   NO
     * @是否索引   NO
     */
    private String askQty;

    /**
     * 当日均价=(turnover/qty)
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal avgPrice;

    /**
     * 十档申买价
     *
     * @最大长度   100
     * @允许为空   NO
     * @是否索引   NO
     */
    private String bid;

    /**
     * 十档申买量
     *
     * @最大长度   100
     * @允许为空   NO
     * @是否索引   NO
     */
    private String bidQty;

    /**
     * 今收盘
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal closePrice;

    /**
     * 预留
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal currDelta;

    /**
     * 行情时间
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Date dataTime;

    /**
     * 交易所类型 上海 1， 深圳 2， 未知 3
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer exchangeType;

    /**
     * 最高价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal highPrice;

    /**
     * 最新价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal lastPrice;

    /**
     * 跌停价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal lowerLimitPrice;

    /**
     * 最低价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal lowPrice;

    /**
     * 今日开盘价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal openPrice;

    /**
     * 昨日收盘价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal preClosePrice;

    /**
     * 昨日预留
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal preDelta;

    /**
     * 昨日结算价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal preSettlementPrice;

    /**
     * 昨日持仓量(张)(目前未填写)
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long preTotalLongPositon;

    /**
     * 数量，为总成交量（单位股，与交易所一致）
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long qty;

    /**
     * 今日结算价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal settlementPrice;

    /**
     * 股票代码
     *
     * @最大长度   100
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticker;

    /**
     * 当前交易状态说明
     *
     * @最大长度   100
     * @允许为空   NO
     * @是否索引   NO
     */
    private String tickerStatus;

    /**
     * 持仓量(张)
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long totalLongPositon;

    /**
     * 成交笔数
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Long tradesCount;

    /**
     * 成交金额，为总成交金额（单位元，与交易所一致）
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal turnover;

    /**
     * 涨停价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal upperLimitPrice;

    /**
     * 创建时间
     *
     * @允许为空   NO
     * @是否索引   YES
     */
    private Date createTime;


}