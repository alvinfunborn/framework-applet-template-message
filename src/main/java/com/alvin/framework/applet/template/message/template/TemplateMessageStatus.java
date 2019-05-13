package com.alvin.framework.applet.template.message.template;

/**
 * datetime 2019/4/24 19:31
 * message status
 *
 * @author sin5
 */
public enum TemplateMessageStatus {

    /**
     * waiting for formId
     */
    waiting,
    /**
     * accumulating formId
     */
    accumulating,
    /**
     * pushing
     */
    pushing,
    /**
     * push success
     */
    pushed,
    /**
     * push failed
     */
    failed;

}
