package com.bazinga.capital.component;

import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.dto.TickerConfigDTO;
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

    @Autowired
    private OrderInfoPersistComponent orderInfoPersistComponent;

    public void dealWithOrderInfo(OrderResponse orderResponse) {
        try {
            orderInfoPersistComponent.orderInfoPersist(orderResponse);
        } catch (Exception e) {
            log.error("同步保存订单信息异常 ticker=" + orderResponse.getTicker() + "orderXtpId="
                    + orderResponse.getOrderXtpId(), e);
        }
        TickerConfigDTO tickerConfigDTO = CacheDataCenter.TICKER_CONFIG_MAP.get(orderResponse.getTicker());
        switch (orderResponse.getOrderStatusType()) {
            case XTP_ORDER_STATUS_NOTRADEQUEUEING:
                log.info("未成交 ,ticker={}, orderXtpId = {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                threadPool.schedule(() -> {
                    cancelOrderComponent.checkCirculationAndCancelOrder(orderResponse.getTicker(), orderResponse.getOrderXtpId());
                }, tickerConfigDTO.getCheckCirculateDelay(), TimeUnit.SECONDS);
                break;
            case XTP_ORDER_STATUS_INIT:
                log.info("order response 初始化 ,ticker={}, orderXtpId = {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                threadPool.schedule(() -> {
                    cancelOrderComponent.checkCirculationAndCancelOrder(orderResponse.getTicker(), orderResponse.getOrderXtpId());
                }, tickerConfigDTO.getCheckCirculateDelay(), TimeUnit.SECONDS);
                break;
            case XTP_ORDER_STATUS_CANCELED:
                CacheDataCenter.DISABLE_INSERT_ORDER_SET.remove(orderResponse.getTicker());
                log.info("撤单成功 ticker ={}, orderXtpId= {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                break;
            case XTP_ORDER_STATUS_ALLTRADED:
                log.info("全部成交 ticker = {}, orderXtpId = {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                break;
            case XTP_ORDER_STATUS_REJECTED:
                log.info("已拒绝 ticker = {}, orderXtpId = {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                CacheDataCenter.TICKER_PERSIST_SET.remove(orderResponse.getTicker());
                break;
            case XTP_ORDER_STATUS_PARTTRADEDQUEUEING:
                log.info("部分成交 ticker = {}, orderXtpId = {}", orderResponse.getTicker(), orderResponse.getOrderXtpId());
                break;
            default:
                break;
        }
    }
}
