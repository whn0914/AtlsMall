package com.atlsmall.common.resp;


import com.atlsmall.common.enums.StatusCode;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sxw on 2015/9/3.
 * 返回值
 */
public class Result {
    private int code;
    private String msg;
    private Object data;
    private Long crc = new Date().getTime();

    public Result() {
        this(StatusCode.SUCCESS, null);
    }

    public Result(StatusCode statusCode) {
        this(statusCode, null);
    }

    public Result(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    public Result(StatusCode statusCode, Object data, String msg) {
        if (statusCode.getMsg() != null && !statusCode.getMsg().trim().equals("")){
            this.msg = statusCode.getMsg()  + ","+ msg;
        }else {
            this.msg = msg;
        }
        this.code = statusCode.getCode();
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success() {
        return success(null);
    }

    public static Result success(Object data) {
        return new Result(StatusCode.SUCCESS, data);
    }

    public static Result error(StatusCode statusCode) {
        return error(statusCode, null);
    }

    public static Result error(StatusCode statusCode, Object data) {
        return new Result(statusCode, data);
    }
    public static Result error(StatusCode statusCode, Object data, String msg) {
        if (msg != null && !msg.trim().equals("")){
            return new Result(statusCode, data, msg);
        } else {
            return new Result(statusCode, data);
        }
    }

    /**
     * 数组使用对象包裹起来
     * @param list
     * @return
     */
    public static Result success(List list) {
        if (list == null) {
            return new Result(StatusCode.SUCCESS, null);
        }
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("list", list);
        return success(resp);
    }

    public Long getCrc() {
        return crc;
    }

    public void setCrc(Long crc) {
        this.crc = crc;
    }
}
