package com.bazinga.capital.api;

/**
 * 行情接口
 */
public interface QuoteApiService {

     void connect();

     void disconnect();

     int login();

     int logout();



     void setHeartBeatInterval(int var1);

     int subscribeMarketData(String[] var1, int var2, int var3);

     int unSubscribeMarketData(String[] var1, int var2, int var3);

     int subscribeOrderBook(String[] var1, int var2, int var3);

     int unSubscribeOrderBook(String[] var1, int var2, int var3);

     int subscribeTickByTick(String[] var1, int var2, int var3);

     int unSubscribeTickByTick(String[] var1, int var2, int var3);

     int subscribeAllMarketData(int var1);

     int unSubscribeAllMarketData(int var1);

     int subscribeAllOrderBook(int var1);

     int unSubscribeAllOrderBook(int var1);

     int subscribeAllTickByTick(int var1);

     int unSubscribeAllTickByTick(int var1);

     int queryAllTickers(int var1);

     int queryTickersPriceInfo(String[] var1, int var2, int var3);

     int subscribeAllOptionMarketData(int var1);

     int unSubscribeAllOptionMarketData(int var1);

     int subscribeAllOptionOrderBook(int var1);

     int unSubscribeAllOptionOrderBook(int var1);

     int subscribeAllOptionTickByTick(int var1);

     int unSubscribeAllOptionTickByTick(int var1);
}
