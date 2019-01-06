package com.bazinga.capital.component;

import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.handler.AbstractTransDataHandler;
import com.bazinga.capital.handler.TransDataHandlerFactory;
import com.bazinga.capital.util.ThreadPoolUtils;
import com.zts.xtp.trade.model.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2019/1/6
 */
@Component
@Slf4j
public class OnOrderEventComponent {

    private static final ScheduledExecutorService threadPool = ThreadPoolUtils.createScheduled(4, "delayGetMarket");

    @Autowired
    private CancelOrderComponent cancelOrderComponent;

    public void dealWithOrderInfo(OrderResponse orderResponse) {

        AbstractTransDataHandler<OrderResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.ORDER_RESPONSE.getCode());
        handler.transDataToPersist(orderResponse);
        TickerConfigDTO tickerConfigDTO = CacheDataCenter.TICKER_CONFIG_MAP.get(orderResponse.getTicker());
        switch (orderResponse.getOrderStatusType()) {
            case XTP_ORDER_STATUS_NOTRADEQUEUEING:
                threadPool.schedule(() -> {
                    cancelOrderComponent.checkCirculationAndCancelOrder(orderResponse.getTicker(), orderResponse.getOrderXtpId());
                }, tickerConfigDTO.getCheckCirculateDelay(), TimeUnit.SECONDS);
                break;
            case XTP_ORDER_STATUS_INIT:
                threadPool.schedule(() -> {
                    cancelOrderComponent.checkCirculationAndCancelOrder(orderResponse.getTicker(), orderResponse.getOrderXtpId());
                }, tickerConfigDTO.getCheckCirculateDelay(), TimeUnit.SECONDS);
                break;
            case XTP_ORDER_STATUS_CANCELED:
                CacheDataCenter.DISABLE_INSERT_ORDER_SET.remove(orderResponse.getTicker());
                log.info("撤单成功 ticker ={}, orderXtpId= {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                break;
            case XTP_ORDER_STATUS_ALLTRADED:
                log.info("交易成功 ticker = {}, orderXtpId = {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
            default:
                break;
        }
    }
}
