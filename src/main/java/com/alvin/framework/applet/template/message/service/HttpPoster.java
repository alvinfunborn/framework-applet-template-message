package com.alvin.framework.applet.template.message.service;

/**
 * datetime 2019/4/26 17:01
 *
 * @author sin5
 */
public interface HttpPoster {

    /**
     * http post
     * content-type="application/json; charset=utf-8"
     *
     * @param url url
     * @param body json body
     * @return response content
     */
    String post(String url, String body);
}
