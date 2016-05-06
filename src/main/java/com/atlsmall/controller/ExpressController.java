package com.atlsmall.controller;

import com.atlsmall.common.enums.StatusCode;
import com.atlsmall.common.resp.ExpressResultResp;
import com.atlsmall.common.resp.OrderWithExpressResp;
import com.atlsmall.common.resp.Result;
import com.atlsmall.service.ExpressService;
import com.atlsmall.service.KDNiaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by haonan on 16/5/1.
 */
@Controller
@RequestMapping(value = "/express")
public class ExpressController {
    @Resource
    private KDNiaoService kdNiaoService;

    @Resource
    private ExpressService expressService;

    @RequestMapping("/query")
    @ResponseBody
    public Result getShipping(@RequestParam("expCode") String expCode, @RequestParam("expNo") String expNo) {
        ExpressResultResp res = kdNiaoService.getExpressTraces(expCode, expNo);
        if(res == null) {
            return Result.error(StatusCode.ERROR_COMMON);
        }
        return Result.success(res);
    }

    @RequestMapping("/getOrders")
    @ResponseBody
    public Result getOrders(@RequestParam("phone") String phone) {
        List<OrderWithExpressResp> res = expressService.getOrders(phone);
        return Result.success(res);
    }
}
