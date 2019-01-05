package com.bazinga.capital.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.component.CancelOrderComponent;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.handler.AbstractTransDataHandler;
import com.bazinga.capital.handler.TransDataHandlerFactory;
import com.bazinga.capital.util.ThreadPoolUtils;
import com.zts.xtp.common.model.ErrorMessage;
import com.zts.xtp.trade.model.response.*;
import com.zts.xtp.trade.spi.TradeSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Service
@Slf4j
public class TradeSpiImpl implements TradeSpi {
    private static final ScheduledExecutorService threadPool = ThreadPoolUtils.createScheduled(4, "delayGetMarket");

    @Autowired
    private CancelOrderComponent cancelOrderComponent;

    @Override
    public void onDisconnect(String sessionId, int reason) {
    }

    @Override
    public void onError(ErrorMessage errorMessage) {
    }

    @Override
    public void onFundTransfer(FundTransferResponse fundTransferInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onOrderEvent(OrderResponse orderResponse, ErrorMessage errorMessage, String sessionId) {
        log.info("on callBack onOrderEvent");
        AbstractTransDataHandler<OrderResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.ORDER_RESPONSE.getCode());
        handler.transDataToPersist(orderResponse);
        switch (orderResponse.getOrderStatusType()) {
            case XTP_ORDER_STATUS_NOTRADEQUEUEING:
                threadPool.schedule(() -> {
                    cancelOrderComponent.checkCirculationAndCancelOrder(orderResponse.getTicker(),orderResponse.getOrderXtpId());
                }, 10, TimeUnit.SECONDS);
                break;
            default:
                break;
        }

    }

    @Override
    public void onQueryAsset(AssetResponse assetResponse, ErrorMessage errorMessage, String sessionId) {
        log.info("on callBack onQueryAsset");
        AbstractTransDataHandler<AssetResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.ASSET_RESPONSE.getCode());
        handler.transDataToPersist(assetResponse);
    }

    @Override
    public void onQueryETF(ETFBaseResponse etfBaseInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryETFBasket(ETFComponentResponse etfComponentInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryFundTransfer(FundTransferResponse fundTransferInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryIPOInfoList(IPOTickerResponse ipoTickerInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryIPOQuotaInfo(IPOQuotaResponse ipoQuotaInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryOrder(OrderResponse orderInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryPosition(StockPositionResponse stockPositionInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryStructuredFund(StructuredFundResponse structuredFundInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onQueryTrade(TradeResponse tradeInfo, ErrorMessage errorMessage, String sessionId) {
    }

    @Override
    public void onTradeEvent(TradeResponse tradeResponse, String sessionId) {
        log.info("TradeResponse= {},", JSONObject.toJSONString(tradeResponse));
    }

    @Override
    public void onCancelOrderError(OrderCancelResponse orderCancelInfo, ErrorMessage errorMessage, String sessionId) {
    }
}
