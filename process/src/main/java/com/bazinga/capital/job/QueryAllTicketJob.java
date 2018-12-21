package com.bazinga.capital.job;

import com.bazinga.capital.service.QuoteApiService;
import com.zts.xtp.common.enums.ExchangeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yunshan
 * @date 2018/12/21
 */

@Component
public class QueryAllTicketJob {

    @Autowired
    private QuoteApiService quoteApiService;

    public void execute(){
        quoteApiService.queryAllTickers(ExchangeType.SZ.getType());
    }
}
