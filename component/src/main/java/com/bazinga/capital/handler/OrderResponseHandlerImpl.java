package com.bazinga.capital.handler;

import com.bazinga.capital.component.OrderInfoPersistComponent;
import com.bazinga.capital.enums.*;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.service.OrderInfoService;
import com.bazinga.capital.util.DateUtil;
import com.zts.xtp.trade.model.response.OrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yunshan
 * @date 2018/12/26
 */
@Service
@Slf4j
public class OrderResponseHandlerImpl extends AbstractTransDataHandler<OrderResponse> {

    @Autowired
    private OrderInfoPersistComponent orderInfoPersistComponent;

    @Override
    public void transDataToPersist(OrderResponse response) {
        executorService.execute(() -> {
            orderInfoPersistComponent.orderInfoPersist(response);
        });
    }


    @Override
    String handlerMapKey() {
        return ApiResponseEnum.ORDER_RESPONSE.getCode();
    }
}
