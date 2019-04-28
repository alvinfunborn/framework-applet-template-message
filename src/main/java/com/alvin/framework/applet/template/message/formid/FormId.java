package com.alvin.framework.applet.template.message.formid;

/**
 * datetime 2019/4/26 11:54
 *
 * @author sin5
 */
public class FormId {

    /**
     * formId
     */
    private String formId;
    /**
     * create time of the formId
     */
    private long createTime;

    public FormId() {
    }

    public FormId(String formId, long createTime) {
        this.formId = formId;
        this.createTime = createTime;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
