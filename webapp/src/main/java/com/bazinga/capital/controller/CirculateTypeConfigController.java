package com.bazinga.capital.controller;

import com.alibaba.fastjson.JSONObject;
import com.bazinga.capital.model.CirculateTypeConfig;
import com.bazinga.capital.query.CirculateTypeConfigQuery;
import com.bazinga.capital.response.PlatformResult;
import com.bazinga.capital.service.CirculateTypeConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yunshan
 * @date 2019/1/9
 */
@Controller
@RequestMapping("config")
@Slf4j
public class CirculateTypeConfigController {

    @Autowired
    private CirculateTypeConfigService circulateTypeConfigService;

    @RequestMapping(value = "dataList", method = RequestMethod.POST)
    @ResponseBody
    public PlatformResult getDataList() {
        PlatformResult platformResult = PlatformResult.buildFailureResult();
        try {
            List<CirculateTypeConfig> list = circulateTypeConfigService.listByCondition(new CirculateTypeConfigQuery());
            platformResult.setCode(PlatformResult.SUCCESS);
            platformResult.setData(list);
            platformResult.setMsg("success");
        } catch (Exception e) {
            log.error("getDataList 系统异常", e);
            platformResult.setMsg("系统异常");
        }
        return platformResult;
    }

    @RequestMapping(value = "getById", method = RequestMethod.POST)
    @ResponseBody
    public PlatformResult getById(Long id) {
        PlatformResult platformResult = PlatformResult.buildFailureResult();
        try {
            Assert.notNull(id, "id 不能为空");
            CirculateTypeConfig byId = circulateTypeConfigService.getById(id);
            platformResult.setData(byId);
            platformResult.setCode(PlatformResult.SUCCESS);
            platformResult.setMsg("success");
        } catch (IllegalArgumentException e) {
            log.error("参数校验失败 参数=" + id, e);
            platformResult.setMsg("参数校验失败");
        } catch (Exception e) {
            log.error("系统异常 参数=" + id, e);
            platformResult.setMsg("系统异常");
        }
        return platformResult;
    }


    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public PlatformResult update(CirculateTypeConfig config) {
        PlatformResult platformResult = PlatformResult.buildFailureResult();
        try {
            Assert.notNull(config.getId(), "更新主键不能为空");
            Assert.notNull(config, "更新对象不能为空");
            circulateTypeConfigService.updateById(config);
        } catch (IllegalArgumentException e) {
            log.error("参数校验异常 参数=" + JSONObject.toJSONString(config), e);
            platformResult.setMsg("参数校验异常");
        } catch (Exception e) {
            log.error("系统异常 参数=" + JSONObject.toJSONString(config), e);
            platformResult.setMsg("系统异常");
        }
        return platformResult;
    }

}
