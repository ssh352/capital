package com.bazinga.capital.handler;

import com.bazinga.capital.component.TickByTickComponent;
import com.bazinga.capital.enums.ApiResponseEnum;
import com.zts.xtp.quote.model.response.TickByTickResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yunshan
 * @date 2018/12/22
 */
@Service
public class TickByTickHandlerImpl extends AbstractTransDataHandler<TickByTickResponse> {

    @Autowired
    private TickByTickComponent tickByTickComponent;

    @Override
    public void transDataToPersist(TickByTickResponse response) {
        executorService.execute(() -> {
            tickByTickComponent.save(response);
        });
    }

    @Override
    String handlerMapKey() {
        return ApiResponseEnum.TICK_BY_TICK.getCode();
    }

    @Override
    boolean isSingleThreadPool() {
        return false;
    }
}
