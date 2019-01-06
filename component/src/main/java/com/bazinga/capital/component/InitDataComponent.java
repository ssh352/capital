package com.bazinga.capital.component;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.constant.CommonConstant;
import com.bazinga.capital.model.CirculateInfo;
import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.query.CirculateInfoQuery;
import com.bazinga.capital.query.CirculateTypeConfigQuery;
import com.bazinga.capital.service.CirculateInfoService;
import com.bazinga.capital.service.CirculateTypeConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yunshan
 * @date 2019/1/6
 */
@Component
@Slf4j
public class InitDataComponent {

    @Autowired
    private CirculateTypeConfigService circulateTypeConfigService;

    @Autowired
    private CirculateInfoService circulateInfoService;

    public void initConfigData() {
        CirculateTypeConfigQuery query = new CirculateTypeConfigQuery();
        List<CirculateTypeConfig> circulateTypeConfigs = circulateTypeConfigService.listByCondition(query);
        circulateTypeConfigs.forEach(item -> {
            CacheDataCenter.CONFIG_MAP.put(CommonConstant.CONFIG_MAP_KEY_PREFIX + item.getCirculateType(), item);
            log.info("config-->:{}", JSONObject.toJSONString(item));
        });

        CirculateInfoQuery circulateInfoQuery = new CirculateInfoQuery();
        List<CirculateInfo> circulateInfos = circulateInfoService.listByCondition(circulateInfoQuery);
        circulateInfos.forEach(item -> {
            CacheDataCenter.TICKER_TYPE_MAP.put(item.getTicker(), item.getCirculateType());
        });

    }

}
