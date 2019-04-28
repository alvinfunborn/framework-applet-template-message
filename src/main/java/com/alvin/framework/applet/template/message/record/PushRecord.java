package com.alvin.framework.applet.template.message.record;

/**
 * datetime 2019/4/26 17:08
 *
 * @author sin5
 */
public class PushRecord {

    /**
     * message id
     */
    private String messageId;
    /**
     * receiver openId
     */
    private String openId;
    /**
     * message business
     */
    private String business;
    /**
     * record timestamp
     */
    private long timestamp;
    /**
     * errmsg of push result
     */
    private String errmsg;
    /**
     * if push successful
     */
    private boolean successful;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
