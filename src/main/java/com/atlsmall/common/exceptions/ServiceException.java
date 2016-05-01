package com.atlsmall.common.exceptions;


import com.atlsmall.common.enums.StatusCode;
import org.apache.commons.lang.StringUtils;

/**
 * Created by sxw on 2015/9/3.
 * 业务异常类
 */
public class ServiceException extends RuntimeException {


    private StatusCode statusCode;
    private String msg;
    private Object data;

    /**
     * 常规错误，比如输入参数的检验异常,返回的状态码是一样的，但是信息可能不一样
     *
     * @param msg
     */
    public ServiceException(String msg) {
        this.statusCode = StatusCode.ERROR_COMMON;
        this.msg = msg;
    }

    public ServiceException(String msg, Object data) {
        this.statusCode = StatusCode.ERROR_COMMON;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 这个方法可能会覆盖掉StatusCode原本的提示信息
     *
     * @param statusCode
     * @param msg
     */
    public ServiceException(StatusCode statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public ServiceException(StatusCode statusCode, String msg, Object data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public ServiceException(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public ServiceException(StatusCode statusCode, Object data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public ServiceException(Exception ex) {
        this.msg = ex.getMessage();
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String getMessage() {
        if (msg != null && !msg.trim().equals("")) {
            if (StringUtils.isNotEmpty(statusCode.getMsg())) {
                return statusCode.getMsg() + "," + msg;
            } else {
                return msg;
            }
        }
        return statusCode.getMsg();
    }
}
