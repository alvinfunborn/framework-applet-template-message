package com.alvin.framework.applet.template.message.response;

/**
 * datetime 2019/4/24 16:07
 * response of sending template message to wechat
 *
 * @author sin5
 */
public class Response {

    /**
     * error code
     */
    private int errcode;
    /**
     * error message
     */
    private String errmsg;

    private Object data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsgCode(ResponseCode status) {
        this.errcode = status.getCode();
        this.errmsg = status.getMsg();
    }
}
