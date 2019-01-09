package com.bazinga.capital.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @author yunshan
 * @date 2019/1/9
 */
@Data
public class CancelOrderEvent extends ApplicationEvent {

    private String ticker;

    private String orderXtpId;

    public CancelOrderEvent(Object source, String ticker, String orderXtpId) {
        super(source);
        this.ticker = ticker;
        this.orderXtpId = orderXtpId;
    }
}
