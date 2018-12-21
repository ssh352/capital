package com.bazinga.capital.model;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈普通行情〉<p>
 *
 * @author
 * @date 2018-12-21
 */
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
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer askQty;

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
     * @允许为空   YES
     * @是否索引   NO
     */
    private String bid;

    /**
     * 十档申买量
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer bidQty;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public Integer getAskQty() {
        return askQty;
    }

    public void setAskQty(Integer askQty) {
        this.askQty = askQty;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Integer getBidQty() {
        return bidQty;
    }

    public void setBidQty(Integer bidQty) {
        this.bidQty = bidQty;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getCurrDelta() {
        return currDelta;
    }

    public void setCurrDelta(BigDecimal currDelta) {
        this.currDelta = currDelta;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getLowerLimitPrice() {
        return lowerLimitPrice;
    }

    public void setLowerLimitPrice(BigDecimal lowerLimitPrice) {
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getPreClosePrice() {
        return preClosePrice;
    }

    public void setPreClosePrice(BigDecimal preClosePrice) {
        this.preClosePrice = preClosePrice;
    }

    public BigDecimal getPreDelta() {
        return preDelta;
    }

    public void setPreDelta(BigDecimal preDelta) {
        this.preDelta = preDelta;
    }

    public BigDecimal getPreSettlementPrice() {
        return preSettlementPrice;
    }

    public void setPreSettlementPrice(BigDecimal preSettlementPrice) {
        this.preSettlementPrice = preSettlementPrice;
    }

    public Long getPreTotalLongPositon() {
        return preTotalLongPositon;
    }

    public void setPreTotalLongPositon(Long preTotalLongPositon) {
        this.preTotalLongPositon = preTotalLongPositon;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTickerStatus() {
        return tickerStatus;
    }

    public void setTickerStatus(String tickerStatus) {
        this.tickerStatus = tickerStatus;
    }

    public Long getTotalLongPositon() {
        return totalLongPositon;
    }

    public void setTotalLongPositon(Long totalLongPositon) {
        this.totalLongPositon = totalLongPositon;
    }

    public Long getTradesCount() {
        return tradesCount;
    }

    public void setTradesCount(Long tradesCount) {
        this.tradesCount = tradesCount;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(BigDecimal upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DepthMarketData{" +
                "id=" + id +
                ", ask='" + ask + '\'' +
                ", askQty=" + askQty +
                ", avgPrice=" + avgPrice +
                ", bid='" + bid + '\'' +
                ", bidQty=" + bidQty +
                ", closePrice=" + closePrice +
                ", currDelta=" + currDelta +
                ", dataTime=" + dataTime +
                ", exchangeType=" + exchangeType +
                ", highPrice=" + highPrice +
                ", lastPrice=" + lastPrice +
                ", lowerLimitPrice=" + lowerLimitPrice +
                ", lowPrice=" + lowPrice +
                ", openPrice=" + openPrice +
                ", preClosePrice=" + preClosePrice +
                ", preDelta=" + preDelta +
                ", preSettlementPrice=" + preSettlementPrice +
                ", preTotalLongPositon=" + preTotalLongPositon +
                ", qty=" + qty +
                ", settlementPrice=" + settlementPrice +
                ", ticker='" + ticker + '\'' +
                ", tickerStatus='" + tickerStatus + '\'' +
                ", totalLongPositon=" + totalLongPositon +
                ", tradesCount=" + tradesCount +
                ", turnover=" + turnover +
                ", upperLimitPrice=" + upperLimitPrice +
                ", createTime=" + createTime +
                '}';
    }
}