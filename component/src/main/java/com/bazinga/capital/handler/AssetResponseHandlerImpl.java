package com.bazinga.capital.handler;

import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.model.Asset;
import com.bazinga.capital.service.AssetService;
import com.zts.xtp.trade.model.response.AssetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AssetResponseHandlerImpl extends AbstractTransDataHandler<AssetResponse> {

    @Autowired
    private AssetService assetService;

    @Override
    public void transDataToPersist(AssetResponse response) {
        executorService.execute(()->{
            Asset asset = new Asset();
            transformData(asset,response);
            assetService.save(asset);


        });
    }

    private void transformData(Asset asset, AssetResponse response) {
        asset.setAccountType(response.getAccountType().ordinal()+1);
        asset.setBanlance(new BigDecimal(String.valueOf(response.getBanlance())));
        asset.setWithholdingAmount(new BigDecimal(String.valueOf(response.getWithholdingAmount())));
        asset.setTradeNetting(new BigDecimal(String.valueOf(response.getTradeNetting())));
        asset.setTotalAsset(new BigDecimal(String.valueOf(response.getTotalAsset())));
        asset.setSecurityAsset(new BigDecimal(String.valueOf(response.getSecurityAsset())));
        asset.setPreadvaPay(new BigDecimal(String.valueOf(response.getPreadvaPay())));
        asset.setPayLater(new BigDecimal(String.valueOf(response.getPayLater())));
        asset.setOrigBanlance(new BigDecimal(String.valueOf(response.getOrigBanlance())));
        asset.setFundSellFee(new BigDecimal(String.valueOf(response.getFundSellFee())));
        asset.setFundBuyFee(new BigDecimal(String.valueOf(response.getFundBuyFee())));
        asset.setFundBuyAmount(new BigDecimal(String.valueOf(response.getFundBuyAmount())));
        asset.setFrozenMargin(new BigDecimal(String.valueOf(response.getFrozenMargin())));
        asset.setFrozenExecFee(new BigDecimal(String.valueOf(response.getFrozenExecFee())));
        asset.setFrozenExecCash(new BigDecimal(String.valueOf(response.getFrozenExecCash())));
        asset.setForceFreezeAmount(new BigDecimal(String.valueOf(response.getForceFreezeAmount())));
        asset.setDepositWithdraw(new BigDecimal(String.valueOf(response.getDepositWithdraw())));
        asset.setCaptialAsset(new BigDecimal(String.valueOf(response.getCaptialAsset())));
        asset.setBuyingPower(new BigDecimal(String.valueOf(response.getBuyingPower())));
        asset.setLastResp(response.isLastResp()?1:0);
        asset.setCaptialAsset(new BigDecimal(String.valueOf(response.getCaptialAsset())));
        asset.setCaptialAsset(new BigDecimal(String.valueOf(response.getCaptialAsset())));
        asset.setCaptialAsset(new BigDecimal(String.valueOf(response.getCaptialAsset())));
        asset.setRequestId((long)response.getRequestId());
        asset.setUnknown(response.getUnknown());
    }

    @Override
    String handlerMapKey() {
        return ApiResponseEnum.ASSET_RESPONSE.getCode();
    }
}
