package com.atlsmall.common.resp;

import java.util.Date;
import java.util.List;

/**
 * Created by haonan on 16/4/30.
 */
public class ExpressResultResp {
    private String LogisticCode;
    private String ShipperCode;
    private Boolean Success;
    private String Reason;
    private List<ExpressTracesResp> Traces;

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public Boolean getSuccess() {
        return Success;
    }

    public void setSuccess(Boolean success) {
        Success = success;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public List<ExpressTracesResp> getTraces() {
        return Traces;
    }

    public void setTraces(List<ExpressTracesResp> traces) {
        Traces = traces;
    }
}
