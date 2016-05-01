package com.atlsmall.common.resp;

/**
 * Created by haonan on 16/4/30.
 */
public class ExpressTracesResp {
    private String AcceptTime;
    private String AcceptStation;
    private String Remark;

    public String getAcceptTime() {
        return AcceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        AcceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return AcceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
