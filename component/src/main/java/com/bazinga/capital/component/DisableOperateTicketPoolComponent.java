package com.bazinga.capital.component;

import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.constant.CommonStatusConstant;
import com.bazinga.capital.dto.TickerConfigDTO;
import com.bazinga.capital.model.DisableOperateTicketPool;
import com.bazinga.capital.service.DisableOperateTicketPoolService;
import com.bazinga.capital.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yunshan
 * @date 2019/1/12
 */
@Component
@Slf4j
public class DisableOperateTicketPoolComponent {

    @Autowired
    private DisableOperateTicketPoolService disableOperateTicketPoolService;

    public void tickerAddToDisableInsert(String ticker) {

        String currentDay = DateUtil.format(new Date(), DateUtil.yyyy_MM_dd);
        DisableOperateTicketPool disableOperateTicketPool = disableOperateTicketPoolService.selectByTickerAndDay(ticker, currentDay);
        if (disableOperateTicketPool != null) {
            if (!disableOperateTicketPool.isAllowOperate(CommonStatusConstant.DISABLE_INSERT_MANUAL_OPERATE)) {
                CacheDataCenter.DISABLE_INSERT_ORDER_SET.add(ticker);
                if (disableOperateTicketPool.isAllowBusiness(CommonStatusConstant.DISABLE_INSERT)) {
                    log.info("改股票 已在系统禁止下单池 ticker = {}", ticker);
                } else {
                    disableOperateTicketPool.enableBusiness(CommonStatusConstant.DISABLE_INSERT);
                    disableOperateTicketPoolService.updateByTickerAndDay(disableOperateTicketPool);
                }
            } else {
                log.info("已经人工操作禁止下单选项 ticker = {}", ticker);
            }
        } else {
            DisableOperateTicketPool record = buildDisableOperateTicketPool(ticker, currentDay);
            CacheDataCenter.DISABLE_INSERT_ORDER_SET.add(ticker);
            disableOperateTicketPoolService.save(record);
        }
    }

    private DisableOperateTicketPool buildDisableOperateTicketPool(String ticker, String currentDay) {
        DisableOperateTicketPool disableOperateTicketPool = new DisableOperateTicketPool();
        disableOperateTicketPool.setOperateStatus(0);
        disableOperateTicketPool.setBusinessStatus(CommonStatusConstant.DISABLE_INSERT);
        disableOperateTicketPool.setTicker(ticker);
        TickerConfigDTO tickerConfigDTO = CacheDataCenter.TICKER_CONFIG_MAP.get(ticker);
        if (tickerConfigDTO != null) {
            disableOperateTicketPool.setTickerName(tickerConfigDTO.getTickerName());
        }
        disableOperateTicketPool.setDay(currentDay);
        return disableOperateTicketPool;
    }

}
