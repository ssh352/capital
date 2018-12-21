package com.bazinga.capital.service.impl;

import com.bazinga.capital.model.TicketInfo;
import com.bazinga.capital.service.TicketInfoService;
import com.zts.xtp.common.model.ErrorMessage;
import com.zts.xtp.quote.model.response.*;
import com.zts.xtp.quote.spi.QuoteSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yunshan 
 */
@Service
@Slf4j
public class QuoteSpiImpl implements QuoteSpi{

    @Autowired
    private TicketInfoService ticketInfoService;

    @Override
    public void onDisconnected(int reason) {
    }

    @Override
    public void onError(ErrorMessage errorMessage) {
    }

    @Override
    public void onSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onUnSubMarketData(SpecificTickerResponse ticker, ErrorMessage errorMessage) {
    }

    @Override
    public void onDepthMarketData(DepthMarketDataResponse depthMarketData, DepthMarketDataExResponse depthQuote) {
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
    public void onTickByTick(TickByTickResponse tickData) {
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
    public void onQueryAllTickers(TickerInfoResponse tickerInfoResponse, ErrorMessage errorMessage) {
        log.info("on call back onQueryAllTickers");
        TicketInfo ticketInfo = new TicketInfo();
        BeanUtils.copyProperties(tickerInfoResponse,ticketInfo);
        ticketInfo.setTicketName(tickerInfoResponse.getTickerName());
        ticketInfo.setExchangeType(tickerInfoResponse.getExchangeType().getType());
        ticketInfo.setTickerType(1);
        ticketInfo.setLowerLimitPrice(new BigDecimal(String.valueOf(tickerInfoResponse.getLowerLimitPrice())));
        ticketInfo.setUpperLimitPrice(new BigDecimal(String.valueOf(tickerInfoResponse.getUpperLimitPrice())));
        ticketInfo.setPreClosePrice(new BigDecimal(String.valueOf(tickerInfoResponse.getPreClosePrice())));
        ticketInfo.setPriceTick(new BigDecimal(String.valueOf(tickerInfoResponse.getPriceTick())));
        ticketInfoService.save(ticketInfo);
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
