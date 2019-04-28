package com.alvin.framework.applet.template.message.formid;

/**
 * datetime 2019/4/24 17:57
 *
 * @author sin5
 */
public interface FormIdProvider {

    /**
     * get valid formId
     * 
     * @param openId openId
     * @return formId
     */
    String getValidFormId(String openId);

    /**
     * count valid formId
     *
     * @param openId openId
     * @return number
     */
    int countValidFormId(String openId);
}
