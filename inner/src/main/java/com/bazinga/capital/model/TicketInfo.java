package com.bazinga.capital.model;

import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.Date;

import java.io.Serializable;

/**
 * 〈股票信息〉<p>
 *
 * @author
 * @date 2018-12-21
 */

public class TicketInfo implements Serializable {

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
     * @最大长度   30
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticker;

    /**
     * 股票名称
     *
     * @最大长度   60
     * @允许为空   NO
     * @是否索引   NO
     */
    private String ticketName;

    /**
     * 交易所类型 上海 1， 深圳 2， 未知 3
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer exchangeType;

    /**
     * 合约类型  1 股票 2 其他
     *
     * @允许为空   YES
     * @是否索引   NO
     */
    private Integer tickerType;

    /**
     * 合约最小交易量
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private Integer buyQtyUnit;

    /**
     * 涨停板价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal upperLimitPrice;

    /**
     * 跌停板价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal lowerLimitPrice;

    /**
     * 昨收盘价
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal preClosePrice;

    /**
     * 最小变动价位
     *
     * @允许为空   NO
     * @是否索引   NO
     */
    private BigDecimal priceTick;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "id=" + id +
                ", ticker='" + ticker + '\'' +
                ", ticketName='" + ticketName + '\'' +
                ", exchangeType=" + exchangeType +
                ", tickerType=" + tickerType +
                ", buyQtyUnit=" + buyQtyUnit +
                ", upperLimitPrice=" + upperLimitPrice +
                ", lowerLimitPrice=" + lowerLimitPrice +
                ", preClosePrice=" + preClosePrice +
                ", priceTick=" + priceTick +
                ", createTime=" + createTime +
                '}';
    }
}