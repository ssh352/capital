package com.bazinga.capital.handler;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.model.DepthMarketDataEx;
import com.bazinga.capital.service.DepthMarketDataExService;
import com.zts.xtp.quote.model.response.DepthMarketDataExResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunshan
 * @date 2019/1/2
 */
@Service
public class DepthMarketDataExHandlerImpl extends AbstractTransDataHandler<DepthMarketDataExResponse> {

    @Autowired
    private DepthMarketDataExService depthMarketDataExService;

    @Override
    public void transDataToPersist(DepthMarketDataExResponse response) {
        this.executorService.execute(()->{
            DepthMarketDataEx depthMarketDataEx = new DepthMarketDataEx();
            transformData(response, depthMarketDataEx);
            depthMarketDataExService.save(depthMarketDataEx);
        });
    }

    private void transformData(DepthMarketDataExResponse response, DepthMarketDataEx depthMarketDataEx) {
        depthMarketDataEx.setAsk1Count(response.getAsk1Count());
        depthMarketDataEx.setAsk1Qty(JSONObject.toJSONString(response.getAsk1Qty()));
        depthMarketDataEx.setBid1Count(response.getBid1Count());
        depthMarketDataEx.setBid1Qty(JSONObject.toJSONString(response.getBid1Qty()));
        depthMarketDataEx.setMaxAsk1Count(response.getMaxAsk1Count());
        depthMarketDataEx.setMaxBid1Count(response.getMaxBid1Count());
    }

    @Override
    String handlerMapKey() {
        return ApiResponseEnum.DEPTH_MARKET_DATA_EX_RESPONSE.getCode();
    }
}
