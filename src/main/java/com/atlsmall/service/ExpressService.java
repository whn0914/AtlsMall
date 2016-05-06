package com.atlsmall.service;

import com.atlsmall.common.resp.OrderWithExpressResp;

import java.util.List;

/**
 * Created by haonan on 16/5/6.
 */
public interface ExpressService {
    public List<OrderWithExpressResp> getOrders(String phone);
}
