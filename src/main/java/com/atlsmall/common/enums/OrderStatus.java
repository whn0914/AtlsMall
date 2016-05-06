package com.atlsmall.common.enums;

/**
 * Created by haonan on 16/5/2.
 */
public enum OrderStatus {
    PAID("A", "已付款"),
    EXPRESSING("I", "已发货"),
    CANCELED("C", "订单取消"),
    FINIDSHED("D", "已收货"),
    ;
    String code;
    String msg;
    OrderStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
