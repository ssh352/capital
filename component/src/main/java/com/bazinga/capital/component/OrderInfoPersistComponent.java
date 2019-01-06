package com.bazinga.capital.component;

import com.bazinga.capital.enums.*;
import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.model.OrderInfo;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.service.OrderInfoService;
import com.bazinga.capital.util.DateUtil;
import com.zts.xtp.trade.model.response.OrderResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author yunshan
 * @date 2019/1/6
 */

@Component
public class OrderInfoPersistComponent {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private CapitalOrderInfoService capitalOrderInfoService;

    public void orderInfoPersist(OrderResponse response) {
        OrderInfo orderInfo = new OrderInfo();
        transformData(orderInfo, response);
        orderInfoService.save(orderInfo);
        CapitalOrderInfo capitalOrderInfo = capitalOrderInfoService.getByOrderXtpId(response.getOrderXtpId());
        if (capitalOrderInfo == null) {
            CapitalOrderInfo saveObject = buildCapitalOrderInfo(orderInfo);
            capitalOrderInfoService.save(saveObject);
        } else {
            CapitalOrderInfo forUpdate = new CapitalOrderInfo();
            forUpdate.setOrderXtpId(capitalOrderInfo.getOrderXtpId());
            forUpdate.setTradedQuantity(capitalOrderInfo.getTradedQuantity() + (int) response.getQtyTraded());
            capitalOrderInfoService.updateByOrderXtpId(forUpdate);
        }
    }


    private CapitalOrderInfo buildCapitalOrderInfo(OrderInfo orderInfo) {
        CapitalOrderInfo capitalOrderInfo = new CapitalOrderInfo();
        capitalOrderInfo.setTradedQuantity(orderInfo.getQtyTraded().intValue());
        capitalOrderInfo.setTicketName("");
        capitalOrderInfo.setTicker(orderInfo.getTicker());
        capitalOrderInfo.setStopInsert(EnableStatusEnum.ENABLE.getCode());
        capitalOrderInfo.setStopCancel(EnableStatusEnum.ENABLE.getCode());
        capitalOrderInfo.setStatus(orderInfo.getOrderStatusType());
        capitalOrderInfo.setOrderXtpId(orderInfo.getOrderXtpId());
        capitalOrderInfo.setExchangeType(orderInfo.getMarketType());
        capitalOrderInfo.setQuantity(orderInfo.getQuantity().intValue());
        capitalOrderInfo.setOrderPrice(orderInfo.getPrice());
        return capitalOrderInfo;
    }

    private void transformData(OrderInfo orderInfo, OrderResponse response) {
        BeanUtils.copyProperties(response, orderInfo);
        orderInfo.setTradeAmount(new BigDecimal(String.valueOf(response.getTradeAmount())));
        orderInfo.setPrice(new BigDecimal(String.valueOf(response.getPrice())));
        orderInfo.setCancelTime(DateUtil.parseDate(String.valueOf(response.getCancelTime()), DateUtil.yyyyMMddHHmmssSSS));
        orderInfo.setInsertTime(DateUtil.parseDate(String.valueOf(response.getInsertTime()), DateUtil.yyyyMMddHHmmssSSS));
        orderInfo.setPriceType(response.getPriceType().getType());
        orderInfo.setOrderSubmitStatusType(response.getOrderSubmitStatusType().getType());
        orderInfo.setPriceType(response.getPriceType().getType());
        orderInfo.setSideType(response.getSideType().getType());
        switch (response.getBusinessType()) {
            case XTP_BUSINESS_TYPE_CASH:
                orderInfo.setBusinessType(BusinessTypeEnum.XTP_BUSINESS_TYPE_CASH.getCode());
                break;
            case XTP_BUSINESS_TYPE_IPOS:
                orderInfo.setBusinessType(BusinessTypeEnum.XTP_BUSINESS_TYPE_IPOS.getCode());
                break;
            case XTP_BUSINESS_TYPE_REPO:
                orderInfo.setBusinessType(BusinessTypeEnum.XTP_BUSINESS_TYPE_REPO.getCode());
                break;
            default:
                orderInfo.setBusinessType(BusinessTypeEnum.XTP_BUSINESS_TYPE_UNKNOWN.getCode());
                break;
        }
        switch (response.getMarketType()) {
            case XTP_MKT_INIT:
                orderInfo.setMarketType(MarketTypeEnum.XTP_MKT_INIT.getCode());
                break;
            case XTP_MKT_SH_A:
                orderInfo.setMarketType(MarketTypeEnum.XTP_MKT_SH_A.getCode());
                break;
            case XTP_MKT_SZ_A:
                orderInfo.setMarketType(MarketTypeEnum.XTP_MKT_SZ_A.getCode());
                break;
            default:
                orderInfo.setMarketType(MarketTypeEnum.XTP_MKT_UNKNOWN.getCode());
                break;
        }
        switch (response.getOrderStatusType()) {
            case XTP_ORDER_STATUS_INIT:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_INIT.getCode());
                break;
            case XTP_ORDER_STATUS_CANCELED:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_CANCELED.getCode());
                break;
            case XTP_ORDER_STATUS_ALLTRADED:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_ALLTRADED.getCode());
                break;
            case XTP_ORDER_STATUS_REJECTED:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_REJECTED.getCode());
                break;
            case XTP_ORDER_STATUS_NOTRADEQUEUEING:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_NOTRADEQUEUEING.getCode());
                break;
            case XTP_ORDER_STATUS_PARTTRADEDQUEUEING:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_PARTTRADEDQUEUEING.getCode());
                break;
            case XTP_ORDER_STATUS_PARTTRADEDNOTQUEUEING:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_PARTTRADEDNOTQUEUEING.getCode());
                break;
            default:
                orderInfo.setOrderStatusType(OrderStatusTypeEnum.XTP_ORDER_STATUS_UNKNOWN.getCode());
        }
        switch (response.getPositionEffectType()) {
            case XTP_POSITION_EFFECT_INIT:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_INIT.getCode());
                break;
            case XTP_POSITION_EFFECT_OPEN:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_OPEN.getCode());
                break;
            case XTP_POSITION_EFFECT_CLOSE:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_CLOSE.getCode());
                break;
            case XTP_POSITION_EFFECT_FORCEOFF:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_FORCEOFF.getCode());
                break;
            case XTP_POSITION_EFFECT_CLOSETODAY:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_CLOSETODAY.getCode());
                break;
            case XTP_POSITION_EFFECT_FORCECLOSE:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_FORCECLOSE.getCode());
                break;
            case XTP_POSITION_EFFECT_CLOSEYESTERDAY:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_CLOSEYESTERDAY.getCode());
                break;
            case XTP_POSITION_EFFECT_LOCALFORCECLOSE:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_LOCALFORCECLOSE.getCode());
                break;
            default:
                orderInfo.setPositionEffectType(PositionEffectTypeEnum.XTP_POSITION_EFFECT_UNKNOWN.getCode());
                break;
        }
    }
}
