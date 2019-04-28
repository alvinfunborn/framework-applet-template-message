package com.alvin.framework.applet.template.message.response;

/**
 * datetime 2019/4/24 16:10
 *
 * @author sin5
 */
public enum ResponseCode {

    ok(0, "ok"),
    http_error(10, "http error"),
    no_valid_formid(11, "no valid formid"),
    break_push_time_rule(12, "break push time rule"),
    insufficient_formid(13, "insufficient formid");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
