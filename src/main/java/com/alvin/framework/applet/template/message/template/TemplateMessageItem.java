package com.alvin.framework.applet.template.message.template;

import com.alvin.framework.applet.template.message.annotation.NotNull;

/**
 * datetime 2019/4/26 17:23
 *
 * @author sin5
 */
public class TemplateMessageItem {

    private String messageId;
    @NotNull
    private String openId;
    private String business;
    @NotNull
    private TemplateMessage templateMessage;
    @NotNull
    private TemplateMessageStatus status;
    private long createTime = System.currentTimeMillis();
    private boolean instant = true;

    public TemplateMessageItem() {
    }

    public TemplateMessageItem(String messageId,
                               String openId,
                               String business,
                               TemplateMessage templateMessage,
                               TemplateMessageStatus status,
                               long createTime,
                               boolean instant) {
        this.messageId = messageId;
        this.openId = openId;
        this.business = business;
        this.templateMessage = templateMessage;
        this.status = status;
        this.createTime = createTime;
        this.instant = instant;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public TemplateMessage getTemplateMessage() {
        return templateMessage;
    }

    public void setTemplateMessage(TemplateMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    public TemplateMessageStatus getStatus() {
        return status;
    }

    public void setStatus(TemplateMessageStatus status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public boolean isInstant() {
        return instant;
    }

    public void setInstant(boolean instant) {
        this.instant = instant;
    }
}
