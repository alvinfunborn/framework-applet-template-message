package com.alvin.framework.applet.template.message.pusher;

import com.alvin.framework.applet.template.message.response.Response;
import com.alvin.framework.applet.template.message.template.TemplateMessage;
import com.alvin.framework.applet.template.message.annotation.NotNull;

/**
 * datetime 2019/4/24 15:50
 *
 * @author sin5
 */
public interface TemplatePusher {

    /**
     * save formId
     *
     * @param openId openId
     * @param formId formId
     * @param timestamp timestamp
     */
    void saveFormId(@NotNull String openId, @NotNull String formId, long timestamp);

    /**
     * push template message to user
     *
     * @param templateMessage template message
     * @param business business of message for push control
     * @param instant push instantly, discard message if push failed
     */
    Response push(@NotNull TemplateMessage templateMessage, String business, boolean instant);

    /**
     * run something when application initialized
     */
    void onInit();
}
