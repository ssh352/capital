package com.bazinga.capital.component;

import com.bazinga.capital.model.TickByTick;
import com.bazinga.capital.model.TickByTickEntrust;
import com.bazinga.capital.service.TickByTickEntrustService;
import com.bazinga.capital.service.TickByTickService;
import com.zts.xtp.common.enums.ExchangeType;
import com.zts.xtp.quote.model.response.TickByTickEntrustResponse;
import com.zts.xtp.quote.model.response.TickByTickResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Component
public class TickByTickComponent {

    @Autowired
    private TickByTickService tickByTickService;

    @Autowired
    private TickByTickEntrustService tickByTickEntrustService;

    public void save(TickByTickResponse tickByTickResponse) {
        TickByTick tickByTick = new TickByTick();
        transTickByTickData(tickByTickResponse, tickByTick);

        switch (tickByTickResponse.getType()) {
            case ORDER:
                TickByTickEntrust tickByTickEntrust = new TickByTickEntrust();
                TickByTickEntrustResponse entrustResponse = tickByTickResponse.getEntrust();
                Assert.notNull(entrustResponse, "逐笔委托不能为空");
                BeanUtils.copyProperties(entrustResponse, tickByTickEntrust);
                tickByTickEntrust.setPrice(new BigDecimal(String.valueOf(entrustResponse.getPrice())));
                TickByTickEntrust save = tickByTickEntrustService.save(tickByTickEntrust);
                tickByTick.setEntrustId(save.getId());
                break;
            case TRADE:
                //todo
            default:
                break;
        }

        tickByTickService.save(tickByTick);
    }

    private void transTickByTickData(TickByTickResponse tickByTickResponse, TickByTick tickByTick) {
        tickByTick.setDatetime(String.valueOf(tickByTickResponse.getDataTime()));
        tickByTick.setExchangeType(ExchangeType.SZ.getType());
        tickByTick.setSeq(tickByTickResponse.getSeq());
        tickByTick.setTicker(tickByTickResponse.getTicker());
        tickByTick.setType(tickByTickResponse.getType().getTbtType());
    }

}
