package com.alvin.framework.applet.template.message.formid;

import com.alvin.framework.applet.template.message.service.AppletRepository;

/**
 * datetime 2019/4/24 17:58
 *
 * @author sin5
 */
public class StandardFormIdProvider implements FormIdProvider {

    private long formIdTimeout = (7 * 24 * 60 * 60 - 10) * 1000L;
    private AppletRepository appletRepository;

    public StandardFormIdProvider() {
    }

    public StandardFormIdProvider(long formIdTimeout) {
        this.formIdTimeout = formIdTimeout;
    }

    public void setAppletRepository(AppletRepository appletRepository) {
        this.appletRepository = appletRepository;
    }

    public String getValidFormId(String openId) {
        while (true) {
            FormId formId = appletRepository.popOldestFormId(openId);
            if (formId == null) {
                break;
            } else {
                if (System.currentTimeMillis() - formId.getCreateTime() < formIdTimeout) {
                    return formId.getFormId();
                }
            }
        }
        return null;
    }

    public int countValidFormId(String openId) {
        while (true) {
            FormId formId = appletRepository.getOldestFormId(openId);
            if (formId == null) {
                return 0;
            } else {
                if (System.currentTimeMillis() - formId.getCreateTime() < formIdTimeout) {
                    Long count = appletRepository.countFormId(openId);
                    return count == null ? 0 : count.intValue();
                } else {
                    appletRepository.popOldestFormId(openId);
                }
            }
        }
    }
}
