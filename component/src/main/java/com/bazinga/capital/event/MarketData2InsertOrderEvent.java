package com.bazinga.capital.event;

import org.springframework.context.ApplicationEvent;

import java.math.BigDecimal;

/**
 * 行情触发下单事件
 * @author yunshan
 * @date 2019/1/4
 */
public class MarketData2InsertOrderEvent extends ApplicationEvent {
    
    private String ticker;

    private BigDecimal orderPrice;

    public MarketData2InsertOrderEvent(Object source, String ticker, BigDecimal orderPrice) {
        super(source);
        this.ticker = ticker;
        this.orderPrice = orderPrice;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
