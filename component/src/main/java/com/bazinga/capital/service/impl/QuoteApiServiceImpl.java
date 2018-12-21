package com.bazinga.capital.service.impl;


import com.bazinga.capital.service.QuoteApiService;
import com.zts.xtp.quote.api.QuoteApi;
import com.zts.xtp.quote.spi.QuoteSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author yunshan
 */
@Service
@PropertySource("classpath:xtp_config.properties")
@Slf4j
public class QuoteApiServiceImpl implements QuoteApiService,InitializingBean {
    private QuoteApi quoteApi;

    private boolean loginFlag;

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

    public boolean isLogin() {
        return loginFlag;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet start--------");
        this.quoteSpi = new QuoteSpiImpl();
        quoteApi = new QuoteApi(quoteSpi);
        quoteApi.connect(clientId, dataFolder);
        quoteApi.setHeartBeatInterval(3);
        int loginResult = quoteApi.login(ip, port, user, password, 1);
        loginFlag = (loginResult == 0);

    }

    @Override
    public void connect(short var1, String var2) {
        quoteApi.connect(var1,var2);
    }

    @Override
    public void disconnect() {
        quoteApi.disconnect();
    }

    @Override
    public int login(String ip, int port, String user, String password, int protocol) {
        return quoteApi.login(ip, port, user, password, protocol);
    }

    @Override
    public int logout() {
        return 0;
    }

    @Override
    public void setHeartBeatInterval(int var1) {

    }

    @Override
    public int subscribeMarketData(String[] tickers, int count, int exchangeId) {
        return this.quoteApi.subscribeMarketData(tickers,count,exchangeId);
    }

    @Override
    public int unSubscribeMarketData(String[] var1, int var2, int var3) {
        return 0;
    }

    @Override
    public int subscribeOrderBook(String[] var1, int var2, int var3) {
        return 0;
    }

    @Override
    public int unSubscribeOrderBook(String[] var1, int var2, int var3) {
        return 0;
    }

    @Override
    public int subscribeTickByTick(String[] var1, int var2, int var3) {
        return 0;
    }

    @Override
    public int unSubscribeTickByTick(String[] var1, int var2, int var3) {
        return 0;
    }

    @Override
    public int subscribeAllMarketData(int var1) {
        return 0;
    }

    @Override
    public int unSubscribeAllMarketData(int var1) {
        return 0;
    }

    @Override
    public int subscribeAllOrderBook(int var1) {
        return 0;
    }

    @Override
    public int unSubscribeAllOrderBook(int var1) {
        return 0;
    }

    @Override
    public int subscribeAllTickByTick(int var1) {
        return 0;
    }

    @Override
    public int unSubscribeAllTickByTick(int var1) {
        return 0;
    }

    @Override
    public int queryAllTickers(int exchangeId) {
        return quoteApi.queryAllTickers(exchangeId);
    }

    @Override
    public int queryTickersPriceInfo(String[] var1, int var2, int var3) {
        return 0;
    }

    @Override
    public int subscribeAllOptionMarketData(int var1) {
        return 0;
    }

    @Override
    public int unSubscribeAllOptionMarketData(int var1) {
        return 0;
    }

    @Override
    public int subscribeAllOptionOrderBook(int var1) {
        return 0;
    }

    @Override
    public int unSubscribeAllOptionOrderBook(int var1) {
        return 0;
    }

    @Override
    public int subscribeAllOptionTickByTick(int var1) {
        return 0;
    }

    @Override
    public int unSubscribeAllOptionTickByTick(int var1) {
        return 0;
    }
}
