package com.bazinga.capital.query;

import com.bazinga.capital.base.PagingQuery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈股票信息 查询参数〉<p>
 *
 * @author
 * @date 2018-12-21
 */

public class TicketInfoQuery extends PagingQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 股票代码
     */
    private String ticker;

    /**
     * 股票名称
     */
    private String ticketName;

    /**
     * 交易所类型 上海 1， 深圳 2， 未知 3
     */
    private Integer exchangeType;

    /**
     * 合约类型  1 股票 2 其他
     */
    private Integer tickerType;

    /**
     * 合约最小交易量
     */
    private Integer buyQtyUnit;

    /**
     * 涨停板价
     */
    private BigDecimal upperLimitPrice;

    /**
     * 跌停板价
     */
    private BigDecimal lowerLimitPrice;

    /**
     * 昨收盘价
     */
    private BigDecimal preClosePrice;

    /**
     * 最小变动价位
     */
    private BigDecimal priceTick;

    /**
     * 创建时间 开始
     */
    private Date createTimeFrom;

    /**
     * 创建时间 结束
     */
    private Date createTimeTo;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Integer getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(Integer exchangeType) {
        this.exchangeType = exchangeType;
    }

    public Integer getTickerType() {
        return tickerType;
    }

    public void setTickerType(Integer tickerType) {
        this.tickerType = tickerType;
    }

    public Integer getBuyQtyUnit() {
        return buyQtyUnit;
    }

    public void setBuyQtyUnit(Integer buyQtyUnit) {
        this.buyQtyUnit = buyQtyUnit;
    }

    public BigDecimal getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(BigDecimal upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public BigDecimal getLowerLimitPrice() {
        return lowerLimitPrice;
    }

    public void setLowerLimitPrice(BigDecimal lowerLimitPrice) {
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public BigDecimal getPreClosePrice() {
        return preClosePrice;
    }

    public void setPreClosePrice(BigDecimal preClosePrice) {
        this.preClosePrice = preClosePrice;
    }

    public BigDecimal getPriceTick() {
        return priceTick;
    }

    public void setPriceTick(BigDecimal priceTick) {
        this.priceTick = priceTick;
    }

    public Date getCreateTimeFrom() {
        return createTimeFrom;
    }

    public void setCreateTimeFrom(Date createTimeFrom) {
        this.createTimeFrom = createTimeFrom;
    }

    public Date getCreateTimeTo() {
        return createTimeTo;
    }

    public void setCreateTimeTo(Date createTimeTo) {
        this.createTimeTo = createTimeTo;
    }
}