package com.bazinga.capital.controller;

import com.bazinga.capital.model.CapitalOrderInfo;
import com.bazinga.capital.query.CapitalOrderInfoQuery;
import com.bazinga.capital.response.PlatformResult;
import com.bazinga.capital.service.CapitalOrderInfoService;
import com.bazinga.capital.util.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yunshan
 * @date 2019/1/9
 */
@Controller
@RequestMapping("/capitalOrder")
@Slf4j
public class CapitalOrderInfoController {

    @Autowired
    private CapitalOrderInfoService capitalOrderInfoService;

    @RequestMapping("dataList")
    @ResponseBody
    public PlatformResult getDataList() {
        PlatformResult platformResult = PlatformResult.buildFailureResult();
        try {
            CapitalOrderInfoQuery query = new CapitalOrderInfoQuery();
            query.setCreateTimeFrom(DateTimeUtils.getDate000000());
            query.setCreateTimeTo(DateTimeUtils.getDate235959());
            List<CapitalOrderInfo> capitalOrderInfos = capitalOrderInfoService.listByCondition(query);
            platformResult.setCode(PlatformResult.SUCCESS);
            platformResult.setData(capitalOrderInfos);
            platformResult.setMsg("success");
        } catch (Exception e) {
            log.error("系统异常", e);
            platformResult.setMsg("系统异常");
        }
        return platformResult;
    }


}
