package com.bazinga.capital.test;

import com.bazinga.capital.model.Asset;
import com.bazinga.capital.service.AssetService;
import com.bazinga.capital.query.AssetQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

/**
* 〈 资产  Test〉<p>
* 〈单元测试〉
*
* @author
* @date 2018-12-22
*/
@ContextConfiguration(locations="classpath:/META-INF/spring/capital-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetTest{

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetTest.class);

    @Resource
    private AssetService assetService;

    @Test
    public void add(){
        Asset asset = new Asset();
        asset.setAccountType(1);
        asset.setBanlance(new BigDecimal("312"));
        asset.setBuyingPower(new BigDecimal("21312"));
        asset.setCaptialAsset(new BigDecimal("321"));
        asset.setDepositWithdraw(new BigDecimal("2131"));
        asset.setForceFreezeAmount(new BigDecimal("33"));
        asset.setFrozenExecCash(new BigDecimal("323"));
        asset.setFrozenExecFee(new BigDecimal("2313"));
        asset.setFrozenMargin(new BigDecimal("2131"));
        asset.setFundBuyAmount(new BigDecimal("2313"));
        asset.setFundBuyFee(new BigDecimal("2131"));
        asset.setFundSellAmount(new BigDecimal("21323"));
        asset.setFundSellFee(new BigDecimal("123"));
        asset.setLastResp(1);
        asset.setOrigBanlance(new BigDecimal("1231"));
        asset.setPayLater(new BigDecimal("543"));
        asset.setPreadvaPay(new BigDecimal("6534"));
        asset.setPreferredAmount(new BigDecimal("34.234"));
        asset.setRequestId(123425L);
        asset.setSecurityAsset(new BigDecimal("4324"));
        asset.setTotalAsset(new BigDecimal("324"));
        asset.setTradeNetting(new BigDecimal("2134"));
        asset.setUnknown(0L);
        asset.setWithholdingAmount(new BigDecimal("324"));

        Asset result = assetService.save(asset);
        LOGGER.info(result.toString());
    }

    @Test
    public void getById(){
        Asset asset = assetService.getById(null);
        LOGGER.info(asset.toString());
    }

    @Test
    public void getByCondition(){
        AssetQuery query=new AssetQuery();
        query.setAccountType(null);
        query.setBanlance(null);
        query.setBuyingPower(null);
        query.setCaptialAsset(null);
        query.setDepositWithdraw(null);
        query.setForceFreezeAmount(null);
        query.setFrozenExecCash(null);
        query.setFrozenExecFee(null);
        query.setFrozenMargin(null);
        query.setFundBuyAmount(null);
        query.setFundBuyFee(null);
        query.setFundSellAmount(null);
        query.setFundSellFee(null);
        query.setLastResp(null);
        query.setOrigBanlance(null);
        query.setPayLater(null);
        query.setPreadvaPay(null);
        query.setPreferredAmount(null);
        query.setRequestId(null);
        query.setSecurityAsset(null);
        query.setTotalAsset(null);
        query.setTradeNetting(null);
        query.setUnknown(null);
        query.setWithholdingAmount(null);
        query.setCreateTimeFrom(null);
        query.setCreateTimeTo(null);

        List<Asset> assets = assetService.listByCondition(query);
        LOGGER.info("query total size: " + assets.size());

    }

    @Test
    public void updateById(){
        Asset asset = assetService.getById(null);
        asset.setAccountType(null);
        asset.setBanlance(null);
        asset.setBuyingPower(null);
        asset.setCaptialAsset(null);
        asset.setDepositWithdraw(null);
        asset.setForceFreezeAmount(null);
        asset.setFrozenExecCash(null);
        asset.setFrozenExecFee(null);
        asset.setFrozenMargin(null);
        asset.setFundBuyAmount(null);
        asset.setFundBuyFee(null);
        asset.setFundSellAmount(null);
        asset.setFundSellFee(null);
        asset.setLastResp(null);
        asset.setOrigBanlance(null);
        asset.setPayLater(null);
        asset.setPreadvaPay(null);
        asset.setPreferredAmount(null);
        asset.setRequestId(null);
        asset.setSecurityAsset(null);
        asset.setTotalAsset(null);
        asset.setTradeNetting(null);
        asset.setUnknown(null);
        asset.setWithholdingAmount(null);

        int result = assetService.updateById(asset);
        Assert.assertTrue(result > 0);
    }
}