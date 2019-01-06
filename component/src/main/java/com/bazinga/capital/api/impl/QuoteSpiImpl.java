package com.bazinga.capital.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.constant.LoginState;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.event.MarketData2InsertOrderEvent;
import com.bazinga.capital.handler.AbstractTransDataHandler;
import com.bazinga.capital.handler.TransDataHandlerFactory;
import com.zts.xtp.common.model.ErrorMessage;
import com.zts.xtp.quote.model.response.*;
import com.zts.xtp.quote.spi.QuoteSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yunshan
 */
@Service
@Slf4j
public class QuoteSpiImpl implements QuoteSpi {

    @Autowired
    private ApplicationContext applicationContext;

    @Resource(name = "depthMarketDataHandlerImpl")
    private AbstractTransDataHandler<DepthMarketDataResponse> handler;

    @Resource(name = "depthMarketDataExHandlerImpl")
    private AbstractTransDataHandler<DepthMarketDataExResponse> exHandler;

    @Override
    public void onDisconnected(int reason) {
        log.error("onDisconnected reason =" + reason);
        LoginState.LOGIN_RESULT = false;
    }

    @Override
    public void onError(ErrorMessage errorMessage) {
        log.error("on error" + JSONObject.toJSONString(errorMessage));
    }

    @Override
    public void onSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        log.info("onSubMarketData");
        if (ticker != null) {
            log.info("exchangeType={},ticker={},lastResp = {}", ticker.getExchangeType().getType(),
                    ticker.getTicker(), ticker.isLastResp());
        }
        if (errorMessage != null) {
            log.error("errorId=" + errorMessage.getErrorId() + "errorMessage = " + errorMessage.getErrorMsg()
                    + "requestId = " + errorMessage.getRequestId());
        }
    }

    @Override
    public void onUnSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        log.info("onUnSubMarketData");
        if (ticker != null) {
            log.info("SpecificTickerResponse ={}", JSONObject.toJSONString(ticker));
        }
        if (errorMessage != null) {
            log.error("SpecificTickerResponse ErrorMessage={}", JSONObject.toJSONString(errorMessage));
        }
    }

    @Override
    public void onDepthMarketData(DepthMarketDataResponse depthMarketData, DepthMarketDataExResponse depthMarketDataExResponse) {
        boolean isSaved = false;
        if (depthMarketData.getLastPrice() == depthMarketData.getUpperLimitPrice()
                && depthMarketData.getDataType().type == 0
                && depthMarketData.getLastPrice()>0
                && !CacheDataCenter.DISABLE_INSERT_ORDER_SET.contains(depthMarketData.getTicker())
                && depthMarketData.getBid()[0]>600000) {
            applicationContext.publishEvent(new MarketData2InsertOrderEvent(this, depthMarketData.getTicker(),
                    new BigDecimal(String.valueOf(depthMarketData.getUpperLimitPrice()))));
            log.info("触发涨停 下单事件发布成功 ticker={} ,price={}", depthMarketData.getTicker(), depthMarketData.getUpperLimitPrice());
            handler.transDataToPersist(depthMarketData);
            exHandler.transDataToPersist(depthMarketDataExResponse);
            log.info("行情触发涨停 ticker = {}", depthMarketData.getTicker());
            isSaved = true;
        }
        if (!isSaved && CacheDataCenter.TICKER_PERSIST_SET.contains(depthMarketData.getTicker())) {
            log.info("行情需要保存 ticker = {}", depthMarketData.getTicker());
            handler.transDataToPersist(depthMarketData);
            exHandler.transDataToPersist(depthMarketDataExResponse);
        }
    }

    @Override
    public void onSubOrderBook(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubOrderBook(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onOrderBook(OrderBookResponse orderBook) {
        log.info("OrderBookResponse= {}", JSONObject.toJSONString(orderBook));
    }

    @Override
    public void onSubTickByTick(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
        log.info(" onSubscribeAllMarketData exchangeId ={}", JSONObject.toJSONString(ticker));
        if (errorMessage != null) {
            log.error("errorId=" + errorMessage.getErrorId() + "errorMessage = " + errorMessage.getErrorMsg()
                    + "requestId = " + errorMessage.getRequestId());
        }
    }

    @Override
    public void onUnSubTickByTick(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onTickByTick(TickByTickResponse tickByTickResponse) {
        log.info("on callBack onQueryAllTickers");
        AbstractTransDataHandler<TickByTickResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.TICK_BY_TICK.getCode());
        handler.transDataToPersist(tickByTickResponse);
    }

    @Override
    public void onSubscribeAllMarketData(int exchangeId, ErrorMessage errorMessage) {
        log.info(" onSubscribeAllMarketData exchangeId ={}", exchangeId);
        if (errorMessage != null) {
            log.error("errorId=" + errorMessage.getErrorId() + "errorMessage = " + errorMessage.getErrorMsg()
                    + "requestId = " + errorMessage.getRequestId());
        }
    }

    @Override
    public void onUnSubscribeAllMarketData(int exchangeId, ErrorMessage errorMessage) {
        log.info(" onUnSubscribeAllMarketData exchangeId ={}", exchangeId);
        if (errorMessage != null) {
            log.error("errorId=" + errorMessage.getErrorId() + "errorMessage = " + errorMessage.getErrorMsg()
                    + "requestId = " + errorMessage.getRequestId());
        }
    }

    @Override
    public void onSubscribeAllOrderBook(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubscribeAllOrderBook(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onSubscribeAllTickByTick(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubscribeAllTickByTick(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onQueryAllTickers(TickerInfoResponse tickerInfo, ErrorMessage errorMessage) {
        log.info("on callBack onQueryAllTickers");
        AbstractTransDataHandler<TickerInfoResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.TICKET_INFO_RESPONSE.getCode());
        handler.transDataToPersist(tickerInfo);
    }

    @Override
    public void onQueryTickersPriceInfo(TickerPriceInfoResponse tickerInfo, ErrorMessage errorMessage) {
    }

    @Override
    public void onSubscribeAllOptionMarketData(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubscribeAllOptionMarketData(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onSubscribeAllOptionOrderBook(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubscribeAllOptionOrderBook(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onSubscribeAllOptionTickByTick(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubscribeAllOptionTickByTick(int exchangeId, ErrorMessage errorMessage) {
    }
}
