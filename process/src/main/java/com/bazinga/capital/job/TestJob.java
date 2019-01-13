package com.bazinga.capital.job;

import com.bazinga.capital.cache.CacheDataCenter;
import com.bazinga.capital.component.OrderInfoPersistComponent;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.query.OrderInfoQuery;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.service.OrderInfoService;
import com.bazinga.capital.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yunshan
 * @date 2018/12/21
 */

@Component
@Slf4j
public class TestJob {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private CapitalOrderInfoService capitalOrderInfoService;

    @Autowired
    private OrderInfoPersistComponent orderInfoPersistComponent;

    public void test() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("job test {}", simpleDateFormat.format(new Date()));
//        OrderInfoQuery query = new OrderInfoQuery();
//        Date createTimeFrom = DateUtil.parseDate("2019-01-11 00:00:00", DateUtil.DEFAULT_FORMAT);
//        Date createTimeTo = DateUtil.parseDate("2019-01-11 23:59:59", DateUtil.DEFAULT_FORMAT);
//        query.setCreateTimeFrom(createTimeFrom);
//        query.setCreateTimeTo(createTimeTo);
//        List<OrderInfo> orderInfos = orderInfoService.listByCondition(query);
//        orderInfos.forEach(item->{
//            CapitalOrderInfo byOrderXtpId = capitalOrderInfoService.getByOrderXtpId(item.getOrderXtpId());
//            if(byOrderXtpId==null){
//                CapitalOrderInfo capitalOrderInfo = orderInfoPersistComponent.buildCapitalOrderInfo(item);
//                capitalOrderInfoService.save(capitalOrderInfo);
//            }else{
//                byOrderXtpId.setStatus(item.getOrderStatusType());
//                byOrderXtpId.setTicketName(CacheDataCenter.TICKER_CONFIG_MAP.get(item.getTicker()).getTickerName());
//                byOrderXtpId.setCancelTime(item.getCancelTime());
//                byOrderXtpId.setTradedQuantity(item.getQtyTraded().intValue());
//                byOrderXtpId.setOrderCancelXtpId(ObjectUtils.toString(item.getOrderCancelXtpId(),""));
//                capitalOrderInfoService.updateByOrderXtpId(byOrderXtpId);
//            }
//        });
    }

}
