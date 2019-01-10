package com.bazinga.capital.api.impl;

import com.bazinga.capital.api.TradeApiService;
import com.zts.xtp.common.enums.TransferProtocol;
import com.zts.xtp.common.enums.XtpLogLevel;
import com.zts.xtp.trade.api.TradeApi;
import com.zts.xtp.trade.model.request.*;
import com.zts.xtp.trade.spi.TradeSpi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Service
@Slf4j
public class TradeApiServiceImpl implements TradeApiService {

    private TradeApi tradeApi;

    @Autowired
    private TradeSpi tradeSpi;

    @Value("${xtp.trade.ip}")
    private String ip;

    @Value("${xtp.trade.port}")
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

    @Value("${xtp.trade.key}")
    private String key;

    private String sessionId;



    private static void loadLibrary(String libFolder) {
        System.load(libFolder + "/libxtptraderapi.so");
        System.load(libFolder + "/libglog.so");
        System.load(libFolder + "/libtradeplugin.so");
    }

    @Override
    public void shutdown() {
        log.info("trade api shut down");
        tradeApi.logout(sessionId);
        tradeApi.disconnect();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            log.error("sleep error");
        }
    }

    @Override
    public String initAndLogin() {
        loadLibrary(libFolder);
        tradeApi = new TradeApi(tradeSpi);
        tradeApi.init(clientId, key, dataFolder, XtpLogLevel.XTP_LOG_LEVEL_INFO);
        sessionId = tradeApi.login(ip, port, user, password, TransferProtocol.XTP_PROTOCOL_TCP);
        log.info("initAndLogin session = {}", sessionId);
        return sessionId;
    }

    @Override
    public String getApiLastError() {
        return tradeApi.getApiLastError();
    }

    @Override
    public String insertOrder(OrderInsertRequest orderInsertRequest) {
        return tradeApi.insertOrder(orderInsertRequest, this.sessionId);
    }

    @Override
    public String cancelOrder(String orderXtpId) {
        return tradeApi.cancelOrder(orderXtpId, sessionId);
    }

    @Override
    public int queryOrderByXtpId(String orderXtpId, int requestId) {
        return tradeApi.queryOrderByXtpId(orderXtpId, sessionId, requestId);
    }

    @Override
    public int queryOrders(OrderQueryRequest orderQueryRequest, int requestId) {
        return tradeApi.queryOrders(orderQueryRequest, sessionId, requestId);
    }

    @Override
    public int queryTradesByXtpId(String orderXtpId, int requestId) {
        return tradeApi.queryTradesByXtpId(orderXtpId, sessionId, requestId);
    }

    @Override
    public int queryTrades(TraderQueryRequest traderQueryRequest, int requestId) {
        return tradeApi.queryTrades(traderQueryRequest, sessionId, requestId);
    }

    @Override
    public int queryPosition(String ticker, int requestId) {
        return tradeApi.queryPosition(ticker, sessionId, requestId);
    }

    @Override
    public int queryAsset(int requestId) {
        return this.tradeApi.queryAsset(this.sessionId, requestId);
    }

    @Override
    public int queryStructuredFund(StructuredFundInfoQueryRequest var1, String var2, int var3) {
        return 0;
    }

    @Override
    public String fundTransfer(FundTransferRequest var1, String var2) {
        return null;
    }

    @Override
    public int queryFundTransfer(FundTransferLogQueryRequest var1, String var2, int var3) {
        return 0;
    }

    @Override
    public int queryETF(ETFBaseQueryRequest var1, String var2, int var3) {
        return 0;
    }

    @Override
    public int queryETFTickerBasket(ETFComponentQueryRequest var1, String var2, int var3) {
        return 0;
    }

    @Override
    public int queryIPOInfoList(int requestId) {
        return tradeApi.queryIPOInfoList(sessionId, requestId);
    }

    @Override
    public int queryIPOQuotaInfo(int requestId) {
        return tradeApi.queryIPOQuotaInfo(sessionId, requestId);
    }
}
