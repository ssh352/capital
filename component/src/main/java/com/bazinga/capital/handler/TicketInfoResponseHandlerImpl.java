package com.bazinga.capital.handler;

import com.bazinga.capital.service.TicketInfoService;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.bazinga.capital.model.TicketInfo;
import com.zts.xtp.quote.model.response.TickerInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Service
@Slf4j
public class TicketInfoResponseHandlerImpl extends ITransDataHandler<TickerInfoResponse> {

    @Autowired
    private TicketInfoService ticketInfoService;

    @Override
    public void transDataToPersist(TickerInfoResponse response) {
        log.info("开始异步处理TickerInfoResponse");
        executorService.execute(() -> {
            TicketInfo ticketInfo = new TicketInfo();
            BeanUtils.copyProperties(response, ticketInfo);
            ticketInfo.setTicketName(response.getTickerName());
            ticketInfo.setExchangeType(response.getExchangeType().getType());
            ticketInfo.setTickerType(1);
            ticketInfo.setLowerLimitPrice(new BigDecimal(String.valueOf(response.getLowerLimitPrice())));
            ticketInfo.setUpperLimitPrice(new BigDecimal(String.valueOf(response.getUpperLimitPrice())));
            ticketInfo.setPreClosePrice(new BigDecimal(String.valueOf(response.getPreClosePrice())));
            ticketInfo.setPriceTick(new BigDecimal(String.valueOf(response.getPriceTick())));
            ticketInfoService.save(ticketInfo);
        });
    }

    @Override
    String handlerMapKey() {
        return ApiResponseEnum.TICKET_INFO_RESPONSE.getCode();
    }
}
