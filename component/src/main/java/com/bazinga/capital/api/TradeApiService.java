package com.bazinga.capital.api;

import com.zts.xtp.trade.model.request.*;

public interface TradeApiService {
    void shutdown();

    String initAndLogin();

    String getApiLastError();

    String insertOrder(OrderInsertRequest var1);

    String cancelOrder(String var1);

    int queryOrderByXtpId(String var1, int var3);

    int queryOrders(OrderQueryRequest var1, int var3);

    int queryTradesByXtpId(String var1, int var3);

    int queryTrades(TraderQueryRequest var1, int var3);

    int queryPosition(String var1, int var3);

    int queryAsset(int var2);

    int queryStructuredFund(StructuredFundInfoQueryRequest var1, String var2, int var3);

    String fundTransfer(FundTransferRequest var1, String var2);

    int queryFundTransfer(FundTransferLogQueryRequest var1, String var2, int var3);

    int queryETF(ETFBaseQueryRequest var1, String var2, int var3);

    int queryETFTickerBasket(ETFComponentQueryRequest var1, String var2, int var3);

    int queryIPOInfoList( int var2);

    int queryIPOQuotaInfo( int var2);
}
