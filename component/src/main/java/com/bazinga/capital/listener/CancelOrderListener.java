package com.bazinga.capital.listener;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.api.TradeApiService;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.event.CancelOrderEvent;
import com.bazinga.capital.model.CancelOrderLog;
import com.bazinga.capital.service.CancelOrderLogService;
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

    @Autowired
    private CancelOrderLogService cancelOrderLogService;

    @Override
    public void onApplicationEvent(CancelOrderEvent cancelOrderEvent) {
        log.info("监听到撤单事件 ticker={},orderXtpId={}", cancelOrderEvent.getTicker(), cancelOrderEvent.getOrderXtpId());

        CancelOrderLog cancelOrderLog =buildCancelOrderLog(cancelOrderEvent.getTicker(),cancelOrderEvent.getOrderXtpId());
        CancelOrderLog saveLog = cancelOrderLogService.save(cancelOrderLog);
        int retryCount=0;
        boolean cancelSuccess = false;
        while (!cancelSuccess && retryCount<3){
            try {
                tradeApiService.cancelOrder(cancelOrderEvent.getOrderXtpId());
                cancelSuccess = true;
            } catch (Exception e) {
                log.error("撤单异常 参数 = "+ JSONObject.toJSONString(cancelOrderEvent));
                retryCount++;
                saveLog.setRetryCount(retryCount);
                saveLog.setStatus(2);
                cancelOrderLogService.updateById(saveLog);
            }
        }
        if (CacheDataCenter.TICKER_PERSIST_SET.contains(cancelOrderEvent.getTicker())) {
            CacheDataCenter.TICKER_PERSIST_SET.remove(cancelOrderEvent.getTicker());
        }
    }

    private CancelOrderLog  buildCancelOrderLog(String ticker,String xtpOrderId) {
        CancelOrderLog cancelOrderLog = new CancelOrderLog();
        cancelOrderLog.setTickerName("");
        cancelOrderLog.setTicker(ticker);
        cancelOrderLog.setOrderXtpId(xtpOrderId);
        cancelOrderLog.setStatus(0);
        cancelOrderLog.setRetryCount(0);
        return cancelOrderLog;
    }
}
