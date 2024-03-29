package com.bazinga.capital.listener;

import com.bazinga.capital.api.QuoteApiService;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.component.InitDataComponent;
import com.bazinga.capital.constant.LoginState;
import com.zts.xtp.common.enums.ExchangeType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yunshan
 * @date 2019/1/6
 */
@Component
@Slf4j
public class SpringInitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private InitDataComponent initDataComponent;

    @Autowired
    private QuoteApiService quoteApiService;

    @Autowired
    private TradeApiService tradeApiService;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(atomicInteger.get()==0 &&
                contextRefreshedEvent.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")){
            log.info("spring initialed ----------->");
            try {
                initDataComponent.initConfigData();
            if (LoginState.LOGIN_RESULT) {
                quoteApiService.subscribeAllMarketData(ExchangeType.SZ.getType());
                log.info("订阅深圳市场行情数据成功");
            }
            } catch (Exception e) {
                log.error("初始化配置信息异常", e);
            }
            log.info("<------数据初始化成功------->");
            if(!LoginState.LOGIN_RESULT){
                quoteApiService.connectAndLogin();
            }
            tradeApiService.initAndLogin();
            log.info("<------登录初始化成功------->");
            atomicInteger.set(-1);
        }


    }
}
