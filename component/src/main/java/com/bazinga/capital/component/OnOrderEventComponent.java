package com.bazinga.capital.component;

import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.handler.AbstractTransDataHandler;
import com.bazinga.capital.handler.TransDataHandlerFactory;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.util.ThreadPoolUtils;
import com.zts.xtp.trade.model.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2019/1/6
 */
@Component
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
            default:
                break;
        }
    }
}
