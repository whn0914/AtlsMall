package com.atlsmall.service;

import com.atlsmall.common.resp.ExpressResultResp;

import java.util.List;

/**
 * Created by haonan on 16/4/30.
 */
public interface KDNiaoService {

    public ExpressResultResp getExpressTraces(String expCode, String expNo);

}
