package com.bazinga.capital.api.impl;

import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.handler.TransDataHandler;
import com.bazinga.capital.handler.TransDataHandlerFactory;
import com.zts.xtp.common.model.ErrorMessage;
import com.zts.xtp.quote.model.response.*;
import com.zts.xtp.quote.spi.QuoteSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yunshan
 */
@Service
@Slf4j
public class QuoteSpiImpl implements QuoteSpi {

    @Override
    public void onDisconnected(int reason) {
        log.error("onDisconnected");
    }

    @Override
    public void onError(ErrorMessage errorMessage) {
        log.error("on error");
    }

    @Override
    public void onSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onDepthMarketData(DepthMarketDataResponse depthMarketData, DepthMarketDataExResponse depthQuote) {
        log.info("on callBack onDepthMarketData");
        TransDataHandler<DepthMarketDataResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.DEPTH_MARKET_DATA_RESPONSE.getCode());
        handler.transDataToPersist(depthMarketData);
    }

    @Override
    public void onSubOrderBook(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubOrderBook(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onOrderBook(OrderBookResponse orderBook) {
    }

    @Override
    public void onSubTickByTick(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubTickByTick(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onTickByTick(TickByTickResponse tickByTickResponse) {
        log.info("on callBack onQueryAllTickers");
        TransDataHandler<TickByTickResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.TICK_BY_TICK.getCode());
        handler.transDataToPersist(tickByTickResponse);
    }

    @Override
    public void onSubscribeAllMarketData(int exchangeId, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubscribeAllMarketData(int exchangeId, ErrorMessage errorMessage) {
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
        TransDataHandler<TickerInfoResponse> handler = TransDataHandlerFactory.createHandler(ApiResponseEnum.TICKET_INFO_RESPONSE.getCode());
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
