package com.bazinga.capital.handler;

import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.model.DepthMarketData;
import com.bazinga.capital.service.DepthMarketDataService;
import com.zts.xtp.quote.model.response.DepthMarketDataResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Service
public class DepthMarketDataHandlerImpl extends AbstractTransDataHandler<DepthMarketDataResponse> {

    @Autowired
    private DepthMarketDataService depthMarketDataService;

    @Override
    public void transDataToPersist(DepthMarketDataResponse response) {
        this.executorService.execute(() -> {
            DepthMarketData depthMarketData = new DepthMarketData();
            transformData(response, depthMarketData);
            depthMarketDataService.save(depthMarketData);

        });
    }

    private void transformData(DepthMarketDataResponse response, DepthMarketData depthMarketData) {
        BeanUtils.copyProperties(response, depthMarketData);
        depthMarketData.setAsk(Objects.toString(response.getAsk(),""));

        depthMarketData.setBid(Objects.toString(response.getBid(),""));
        depthMarketData.setDataTime(new Date(response.getDataTime()));
        depthMarketData.setExchangeType(response.getExchangeType().getType());
        depthMarketData.setClosePrice(new BigDecimal(String.valueOf(response.getClosePrice())));
        depthMarketData.setTurnover(new BigDecimal(String.valueOf(response.getTurnover())));
        depthMarketData.setCurrDelta(new BigDecimal(String.valueOf(response.getCurrDelta())));
        depthMarketData.setHighPrice(new BigDecimal(String.valueOf(response.getHighPrice())));
        depthMarketData.setLastPrice(new BigDecimal(String.valueOf(response.getLastPrice())));
        depthMarketData.setLowerLimitPrice(new BigDecimal(String.valueOf(response.getLowerLimitPrice())));
        depthMarketData.setLowPrice(new BigDecimal(String.valueOf(response.getLowPrice())));
        depthMarketData.setOpenPrice(new BigDecimal(String.valueOf(response.getLowPrice())));
        depthMarketData.setPreClosePrice(new BigDecimal(String.valueOf(response.getPreClosePrice())));
        depthMarketData.setAvgPrice(new BigDecimal(String.valueOf(response.getAvgPrice())));
        depthMarketData.setPreDelta(new BigDecimal(String.valueOf(response.getPreDelta())));
        depthMarketData.setPreSettlementPrice(new BigDecimal(String.valueOf(response.getPreSettlementPrice())));
        depthMarketData.setSettlementPrice(new BigDecimal(String.valueOf(response.getSettlementPrice())));
        depthMarketData.setUpperLimitPrice(new BigDecimal(String.valueOf(response.getUpperLimitPrice())));
    }

    @Override
    String handlerMapKey() {
        return ApiResponseEnum.DEPTH_MARKET_DATA_RESPONSE.getCode();

    }
}
