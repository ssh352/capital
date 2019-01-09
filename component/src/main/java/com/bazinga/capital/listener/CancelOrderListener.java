package com.bazinga.capital.listener;

import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.event.CancelOrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yunshan
 * @date 2019/1/9
 */
@Component
@Slf4j
public class CancelOrderListener implements ApplicationListener<CancelOrderEvent> {

    @Autowired
    private TradeApiService tradeApiService;

    @Override
    public void onApplicationEvent(CancelOrderEvent cancelOrderEvent) {
        log.info("监听到撤单事件 ticker={},orderXtpId={}", cancelOrderEvent.getTicker(), cancelOrderEvent.getOrderXtpId());
        tradeApiService.cancelOrder(cancelOrderEvent.getOrderXtpId());
        if (CacheDataCenter.TICKER_PERSIST_SET.contains(cancelOrderEvent.getTicker())) {
            CacheDataCenter.TICKER_PERSIST_SET.remove(cancelOrderEvent.getTicker());
        }
    }
}
