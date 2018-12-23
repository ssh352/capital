package com.bazinga.capital.test;

import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.service.DepthMarketDataService;
import com.bazinga.capital.query.DepthMarketDataQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import java.util.Date;
import java.util.List;
import org.junit.Assert;

import javax.annotation.Resource;

/**
* 〈 普通行情  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2018-12-21
*/
public class DepthMarketDataTest extends BaseTestCase{

    private static final Logger LOGGER = LoggerFactory.getLogger(DepthMarketDataTest.class);

    @Resource
    private DepthMarketDataService depthMarketDataService;

    @Test
    public void add(){
        DepthMarketData depthMarketData = new DepthMarketData();
        depthMarketData.setAsk(null);
        depthMarketData.setAskQty(null);
        depthMarketData.setAvgPrice(null);
        depthMarketData.setBid(null);
        depthMarketData.setBidQty(null);
        depthMarketData.setClosePrice(null);
        depthMarketData.setCurrDelta(null);
        depthMarketData.setDataTime(null);
        depthMarketData.setExchangeType(null);
        depthMarketData.setHighPrice(null);
        depthMarketData.setLastPrice(null);
        depthMarketData.setLowerLimitPrice(null);
        depthMarketData.setLowPrice(null);
        depthMarketData.setOpenPrice(null);
        depthMarketData.setPreClosePrice(null);
        depthMarketData.setPreDelta(null);
        depthMarketData.setPreSettlementPrice(null);
        depthMarketData.setPreTotalLongPositon(null);
        depthMarketData.setQty(null);
        depthMarketData.setSettlementPrice(null);
        depthMarketData.setTicker(null);
        depthMarketData.setTickerStatus(null);
        depthMarketData.setTotalLongPositon(null);
        depthMarketData.setTradesCount(null);
        depthMarketData.setTurnover(null);
        depthMarketData.setUpperLimitPrice(null);
        depthMarketData.setCreateTime(new Date());

        DepthMarketData result = depthMarketDataService.save(depthMarketData);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        DepthMarketData depthMarketData = depthMarketDataService.getById(null);
        LOGGER.info(depthMarketData.toString());
    }

    @Test
    public void getByCondition(){
        DepthMarketDataQuery query=new DepthMarketDataQuery();
        List<DepthMarketData> depthMarketDatas = depthMarketDataService.listByCondition(query);
        LOGGER.info("query total size: " + depthMarketDatas.size());

    }

    @Test
    public void updateById(){
        DepthMarketData depthMarketData = depthMarketDataService.getById(null);
        depthMarketData.setAsk(null);
        depthMarketData.setAskQty(null);
        depthMarketData.setAvgPrice(null);
        depthMarketData.setBid(null);
        depthMarketData.setBidQty(null);
        depthMarketData.setClosePrice(null);
        depthMarketData.setCurrDelta(null);
        depthMarketData.setDataTime(null);
        depthMarketData.setExchangeType(null);
        depthMarketData.setHighPrice(null);
        depthMarketData.setLastPrice(null);
        depthMarketData.setLowerLimitPrice(null);
        depthMarketData.setLowPrice(null);
        depthMarketData.setOpenPrice(null);
        depthMarketData.setPreClosePrice(null);
        depthMarketData.setPreDelta(null);
        depthMarketData.setPreSettlementPrice(null);
        depthMarketData.setPreTotalLongPositon(null);
        depthMarketData.setQty(null);
        depthMarketData.setSettlementPrice(null);
        depthMarketData.setTicker(null);
        depthMarketData.setTickerStatus(null);
        depthMarketData.setTotalLongPositon(null);
        depthMarketData.setTradesCount(null);
        depthMarketData.setTurnover(null);
        depthMarketData.setUpperLimitPrice(null);

        int result = depthMarketDataService.updateById(depthMarketData);
        Assert.assertTrue(result > 0);
    }
}