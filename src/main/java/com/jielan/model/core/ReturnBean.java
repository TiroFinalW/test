package com.jielan.model.core;

/**
 * Created by wang on 2017/1/16.
 * 返回参数bean
 */
public class ReturnBean {
    private String returnCode;
    private String returnMsg;
    public ReturnBean(String code, String returnMsg){
        this.returnCode=code;
        this.returnMsg=returnMsg;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}