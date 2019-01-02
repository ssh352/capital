package com.bazinga.capital.api.impl;


import com.bazinga.capital.api.QuoteApiService;
import com.bazinga.capital.constant.LoginState;
import com.zts.xtp.quote.api.QuoteApi;
import com.zts.xtp.quote.spi.QuoteSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 */
@Service
@PropertySource("classpath:xtp_config.properties")
@Slf4j
public class QuoteApiServiceImpl implements QuoteApiService, InitializingBean {
    private QuoteApi quoteApi;


    @Autowired
    private QuoteSpi quoteSpi;

    @Value("${xtp.quote.ip}")
    private String ip;

    @Value("${xtp.quote.port}")
    private int port;

    @Value("${xtp.user}")
    private String user;

    @Value("${xtp.password}")
    private String password;

    @Value("${xtp.client_id}")
    private short clientId;

    @Value("${xtp.data_folder}")
    private String dataFolder;

    @Value("${xtp.lib_folder}")
    private String libFolder;


    private static void loadLibrary(String libFolder) {
        System.load(libFolder + "/libxtptraderapi.so");
        System.load(libFolder + "/libxtpquoteapi.so");
        System.load(libFolder + "/libglog.so");
        System.load(libFolder + "/libtradeplugin.so");
        System.load(libFolder + "/libquoteplugin.so");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet start--------");
        loadLibrary(libFolder);
        quoteApi = new QuoteApi(quoteSpi);
        quoteApi.connect(clientId, dataFolder);
        quoteApi.setHeartBeatInterval(3);
        int loginResult = quoteApi.login(ip, port, user, password, 1);
        LoginState.LOGIN_RESULT = (loginResult == 0);
        log.info("logResult={} code={}", LoginState.LOGIN_RESULT, loginResult);

    }

    @Override
    public void connect() {
        quoteApi.connect(clientId, dataFolder);
    }

    @Override
    public void disconnect() {
        quoteApi.disconnect();
    }

    @Override
    public int login() {
        return quoteApi.login(ip, port, user, password, 1);
    }

    @Override
    public int logout() {
        return quoteApi.logout();
    }


    @Override
    public void setHeartBeatInterval(int seconds) {
        setHeartBeatInterval(seconds);
    }

    /**
     * @param tickers    合约ID数组
     * @param count      要订阅/退订行情的合约个数
     * @param exchangeId 交易所代码
     * @return
     */
    @Override
    public int subscribeMarketData(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.subscribeMarketData(tickers, count, exchangeId);
    }

    @Override
    public int unSubscribeMarketData(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.unSubscribeMarketData(tickers, count, exchangeId);
    }

    @Override
    public int subscribeOrderBook(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.subscribeOrderBook(tickers, count, exchangeId);
    }

    @Override
    public int unSubscribeOrderBook(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.unSubscribeOrderBook(tickers, count, exchangeId);
    }

    @Override
    public int subscribeTickByTick(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.subscribeTickByTick(tickers, count, exchangeId);
    }

    @Override
    public int unSubscribeTickByTick(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.unSubscribeTickByTick(tickers, count, exchangeId);
    }

    @Override
    public int subscribeAllMarketData(int exchangeId) {
        return this.quoteApi.subscribeAllMarketData(exchangeId);
    }

    @Override
    public int unSubscribeAllMarketData(int exchangeId) {
        return this.quoteApi.unSubscribeAllMarketData(exchangeId);
    }

    @Override
    public int subscribeAllOrderBook(int exchangeId) {
        return this.quoteApi.subscribeAllOrderBook(exchangeId);
    }

    @Override
    public int unSubscribeAllOrderBook(int exchangeId) {
        return this.quoteApi.unSubscribeAllOrderBook(exchangeId);
    }

    @Override
    public int subscribeAllTickByTick(int exchangeId) {
        return this.quoteApi.subscribeAllTickByTick(exchangeId);
    }

    @Override
    public int unSubscribeAllTickByTick(int exchangeId) {
        return this.quoteApi.unSubscribeAllTickByTick(exchangeId);
    }

    @Override
    public int queryAllTickers(int exchangeId) {
        int result = quoteApi.queryAllTickers(exchangeId);
        return result;

    }

    @Override
    public int queryTickersPriceInfo(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.queryTickersPriceInfo(tickers, count, exchangeId);
    }

    @Override
    public int subscribeAllOptionMarketData(int exchangeId) {
        return this.quoteApi.subscribeAllOptionMarketData(exchangeId);
    }

    @Override
    public int unSubscribeAllOptionMarketData(int exchangeId) {
        return this.quoteApi.unSubscribeAllOptionMarketData(exchangeId);
    }

    @Override
    public int subscribeAllOptionOrderBook(int exchangeId) {
        return this.quoteApi.subscribeAllOptionOrderBook(exchangeId);
    }

    @Override
    public int unSubscribeAllOptionOrderBook(int exchangeId) {
        return this.quoteApi.unSubscribeAllOptionOrderBook(exchangeId);
    }

    @Override
    public int subscribeAllOptionTickByTick(int exchangeId) {
        return this.quoteApi.subscribeAllOptionTickByTick(exchangeId);
    }

    @Override
    public int unSubscribeAllOptionTickByTick(int exchangeId) {
        return this.unSubscribeAllOptionTickByTick(exchangeId);
    }
}
