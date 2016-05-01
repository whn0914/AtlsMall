package com.atlsmall.common.enums;

/**
 * Created by sxw on 2015/9/3.
 * 状态码和信息
 */
public enum StatusCode {

    SUCCESS(1, "成功"),
    ERROR_INPUT(2, "参数错误"),
    ERROR_TIME_OUT(3, "接口超时"),
    ERROR_USER_NOT_EXIST(4, "用户不存在"),
    ERROR_AUTH_FAIL(5, "验证失败"),
    ERROR_404(6, "接口不存在"),
    ERROR_INTERNAL(7, "内部错误"),
    ERROR_REQUIRED_PARAM(8, "缺少参数"),
    //ERROR_REQUIRED_PARAM(13, "缺少参数"),
    ERROR_SERVICE_UNAVAILABLE(9, "服务不可用"),
    //ERROR_SERVICE_UNAVAILABLE(15, "服务不可用"),
    ERROR_DATA_NOT_CHANGED(10, "数据没有变化"),
    ERROR_DATA_INCONSISTENT(11, "数据不一致"),
    ERROR_NETWORK_NOT_EXISTS(12, "网络不存在"),

    ERROR_DB_INSERT_FAIL(1000, "数据库插入失败"),
    ERROR_DB_DELETE_FAIL(1001, "数据库删除失败"),
    ERROR_DB_UPDATE_FAIL(1002, "数据库更新失败"),
    ERROR_THEME_ITEM_NOT_EXIST(1003, "主题项不存在"),
    ERROR_OPERATION_REPEAT(1004, "重复操作"),
    ERROR_DB_DATA_ERROR(1005, "数据库数据异常"),
    ERROR_RECORD_NOT_EXISTS(1006, "不存在的记录"),

    ERROR_COMMON(10000, ""),     //一般错误


    ;
    int code;
    String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
