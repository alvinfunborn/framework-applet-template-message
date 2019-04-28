package com.alvin.framework.applet.template.message.service;

import com.alvin.framework.applet.template.message.formid.FormId;
import com.alvin.framework.applet.template.message.annotation.NotNull;

/**
 * datetime 2019/4/26 11:53
 *
 * @author sin5
 */
public interface AppletRepository {

    String getAccessToken();

    void saveFormId(@NotNull String openId,@NotNull  String formId, long createTime);

    FormId popOldestFormId(@NotNull String openId);

    FormId getOldestFormId(@NotNull String openId);

    Long countFormId(@NotNull String openId);
}
