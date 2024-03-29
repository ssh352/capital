package com.bazinga.capital.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.component.CancelOrderComponent;
import com.bazinga.capital.component.OnOrderEventComponent;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.enums.LoginTypeEnum;
import com.bazinga.capital.event.OnDisconnectedEvent;
import com.bazinga.capital.handler.AbstractTransDataHandler;
import com.bazinga.capital.handler.TransDataHandlerFactory;
import com.bazinga.capital.util.ThreadPoolUtils;
import com.zts.xtp.common.model.ErrorMessage;
import com.zts.xtp.trade.model.response.*;
import com.zts.xtp.trade.spi.TradeSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private OnOrderEventComponent onOrderEventComponent;

    @Override
    public void onDisconnect(String sessionId, int reason) {
        log.error("TradeSpiImpl onDisconnect sessionId = " + sessionId + "reason=" + reason);
        OnDisconnectedEvent event = new OnDisconnectedEvent(this, LoginTypeEnum.TRADE.getCode());
        applicationContext.publishEvent(event);
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
        onOrderEventComponent.dealWithOrderInfo(orderResponse);
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
