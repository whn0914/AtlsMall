package com.atlsmall.controller;

import com.atlsmall.common.enums.StatusCode;
import com.atlsmall.common.resp.Result;
import com.atlsmall.common.resp.ExpressResultResp;
import com.atlsmall.service.KDNiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * Created by haonan on 16/4/21.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private KDNiaoService kdNiaoService;

    @RequestMapping("/hello")
    @ResponseBody
    public Result getAccommodationPeriodicalPrice() {
        return Result.success();
    }

    @RequestMapping("/shipping")
    @ResponseBody
    public Result getShipping(@RequestParam("expCode") String expCode, @RequestParam("expNo") String expNo) {
        ExpressResultResp res = kdNiaoService.getExpressTraces(expCode, expNo);
        if(res == null) {
            return Result.error(StatusCode.ERROR_COMMON);
        }
        return Result.success(res);
    }
}
