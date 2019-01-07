package com.bazinga.capital.listener;

import com.bazinga.capital.api.QuoteApiService;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.constant.LoginState;
import com.bazinga.capital.enums.LoginTypeEnum;
import com.bazinga.capital.event.OnDisconnectedEvent;
import com.zts.xtp.common.enums.ExchangeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yunshan
 * @date 2019/1/6
 */
@Component
@Slf4j
public class OnDisconnectedListener implements ApplicationListener<OnDisconnectedEvent> {

    @Autowired
    private QuoteApiService quoteApiService;

    @Autowired
    private TradeApiService tradeApiService;

    @Override
    public void onApplicationEvent(OnDisconnectedEvent onDisconnectedEvent) {
        if (LoginTypeEnum.QUOTE.getCode() == onDisconnectedEvent.getLoginType()) {
            log.info("监听到行情连接中断 重新连接");
            quoteApiService.connectAndLogin();
            if(LoginState.LOGIN_RESULT){
                log.info("重新订阅深圳行情");
                quoteApiService.subscribeAllMarketData(ExchangeType.SZ.getType());
            }
        } else if (LoginTypeEnum.TRADE.getCode() == onDisconnectedEvent.getLoginType()) {
            log.info("监听到交易连接中断 重新连接");
            tradeApiService.initAndLogin();
        }
    }
}
