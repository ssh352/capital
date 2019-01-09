package com.bazinga.capital.component;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.constant.CommonConstant;
import com.bazinga.capital.model.CirculateInfo;
import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.model.DisableInsertTicket;
import com.bazinga.capital.query.CirculateInfoQuery;
import com.bazinga.capital.query.CirculateTypeConfigQuery;
import com.bazinga.capital.query.DisableInsertTicketQuery;
import com.bazinga.capital.service.CirculateInfoService;
import com.bazinga.capital.service.CirculateTypeConfigService;
import com.bazinga.capital.service.DisableInsertTicketService;
import com.bazinga.capital.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

import static com.bazinga.capital.cache.CacheDataCenter.CONFIG_MAP;

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

    @Autowired
    private DisableInsertTicketService disableInsertTicketService;

    public void initConfigData() {
        initCirculateTypeConfig();

        initTickerConfigDTO();

        initDisableInsertTicket();

    }

    private void initDisableInsertTicket() {
        DisableInsertTicketQuery query= new DisableInsertTicketQuery();
        query.setDay(DateUtil.format(new Date(),DateUtil.yyyy_MM_dd));
        List<DisableInsertTicket> disableInsertTickets = disableInsertTicketService.listByCondition(query);
        disableInsertTickets.forEach(item->{
            CacheDataCenter.DISABLE_INSERT_ORDER_SET.add(item.getTicker());
        });
    }

    private void initTickerConfigDTO() {
        CirculateInfoQuery circulateInfoQuery = new CirculateInfoQuery();
        List<CirculateInfo> circulateInfos = circulateInfoService.listByCondition(circulateInfoQuery);
        circulateInfos.forEach(item -> {
            TickerConfigDTO tickerConfigDTO = new TickerConfigDTO();
            CirculateTypeConfig config = CONFIG_MAP.get(CommonConstant.CONFIG_MAP_KEY_PREFIX + item.getCirculateType());
            tickerConfigDTO.setTickerName(item.getTickerName());
            tickerConfigDTO.setCheckCirculateDelay(config.getCheckCirculateDelay());
            tickerConfigDTO.setPercent(config.getPercent());
            tickerConfigDTO.setMinInsertQuantity(config.getMinInsertQuantity());
            tickerConfigDTO.setCirculateType(config.getCirculateType());
            tickerConfigDTO.setCirculateZ(item.getCirculateZ());
            CacheDataCenter.TICKER_CONFIG_MAP.put(item.getTicker(), tickerConfigDTO);
        });
        log.info("<------------股票配置信息初始化完成--------->");
    }

    private void initCirculateTypeConfig() {
        CirculateTypeConfigQuery query = new CirculateTypeConfigQuery();
        List<CirculateTypeConfig> circulateTypeConfigs = circulateTypeConfigService.listByCondition(query);
        circulateTypeConfigs.forEach(item -> {
            CONFIG_MAP.put(CommonConstant.CONFIG_MAP_KEY_PREFIX + item.getCirculateType(), item);
            log.info("config-->:{}", JSONObject.toJSONString(item));
        });
    }

}
