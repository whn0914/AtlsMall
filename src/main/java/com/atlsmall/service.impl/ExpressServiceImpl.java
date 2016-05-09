package com.atlsmall.service.impl;

import com.atlsmall.common.enums.OrderStatus;
import com.atlsmall.common.resp.OrderWithExpressResp;
import com.atlsmall.dao.CommCodeMapper;
import com.atlsmall.dao.OrderCartMapper;
import com.atlsmall.dao.OrderMgrMapper;
import com.atlsmall.dao.ProductImgMapper;
import com.atlsmall.entity.*;
import com.atlsmall.service.ExpressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by haonan on 16/5/6.
 */
@Service
@Transactional
public class ExpressServiceImpl implements ExpressService {

    @Resource
    OrderMgrMapper orderMgrMapper;

    @Resource
    OrderCartMapper orderCartMapper;

    @Resource
    ProductImgMapper productImgMapper;

    @Resource
    CommCodeMapper commCodeMapper;

    @Override
    public List<OrderWithExpressResp> getOrders(String phone) {
        List<OrderWithExpressResp> res = new ArrayList<>();
        OrderMgrExample mgrExample = new OrderMgrExample();
        mgrExample.setOrderByClause("O_NO desc");
        OrderMgrExample.Criteria mgrCriteria = mgrExample.createCriteria();
        List<String> orderStatus = new ArrayList<>();
        orderStatus.add(OrderStatus.EXPRESSING.getCode());
        orderStatus.add(OrderStatus.PAID.getCode());
        orderStatus.add(OrderStatus.FINIDSHED.getCode());

        mgrCriteria.andOBHpEqualTo(phone).andOStatusIn(orderStatus);
        List<OrderMgr> orderMgrList = orderMgrMapper.selectByExample(mgrExample);
        for(OrderMgr order : orderMgrList) {
            OrderWithExpressResp resp = new OrderWithExpressResp();
            resp.setTitle(order.getoJTitle());
            resp.setPrice(order.getoTotPrice().toString());

            OrderCart cart = getOrderCart(order.getoNo());
            if(cart != null) {
                resp.setExpCode(getExpCode(cart.getOcDeliveryCom()));
                resp.setExpNo(cart.getOcDeliveryNum());
                resp.setImg(getProductImg(cart.getpCode()));
            }
            res.add(resp);
        }
        return res;
    }

    private OrderCart getOrderCart(Long orderNo) {
        OrderCartExample example = new OrderCartExample();
        OrderCartExample.Criteria criteria = example.createCriteria();
        criteria.andONoEqualTo(orderNo);
        List<OrderCart> orderCartList = orderCartMapper.selectByExample(example);
        return orderCartList.size()>0 ? orderCartList.get(0) : null;
    }

    private String getProductImg(String productCode) {
        ProductImgExample example = new ProductImgExample();
        ProductImgExample.Criteria criteria = example.createCriteria();
        criteria.andPCodeEqualTo(productCode);
        List<ProductImg> productImgList = productImgMapper.selectByExample(example);
        return productImgList.size() > 0 ? "http://www.atlsmall.com"+productImgList.get(0).getPmRealName() : "";
    }

    private String getExpCode(String rawCode) {
        if(rawCode == null) {
            return "暂无物流信息";
        }
        CommCodeExample example = new CommCodeExample();
        CommCodeExample.Criteria criteria = example.createCriteria();
        criteria.andCgNoEqualTo(6).andCcCodeEqualTo(rawCode);
        List<CommCode> commCodeList = commCodeMapper.selectByExample(example);
        return commCodeList.size()>0 ? commCodeList.get(0).getCcNameCn() : "一般物流";
    }
}
