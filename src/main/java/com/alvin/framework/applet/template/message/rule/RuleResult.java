package com.alvin.framework.applet.template.message.rule;

/**
 * datetime 2019/4/26 19:55
 *
 * @author sin5
 */
public class RuleResult {

    /**
     * true if pushable
     */
    private boolean pushable;
    /**
     * true if have to waiting for formId
     */
    private Boolean waitForFormId;
    /**
     * have to push after millis
     */
    private Long pushAfterMillis;

    public static RuleResult pushable() {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setPushable(true);
        return ruleResult;
    }

    public static RuleResult unpushable() {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setPushable(false);
        return ruleResult;
    }

    public static RuleResult waitForFormId() {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setPushable(false);
        ruleResult.setWaitForFormId(true);
        return ruleResult;
    }

    public static RuleResult pushAfterMillis(long millis) {
        if (millis <= 0) {
            throw new IllegalArgumentException("millis must be larger than zero");
        }
        RuleResult ruleResult = new RuleResult();
        ruleResult.setPushable(false);
        ruleResult.setPushAfterMillis(millis);
        return ruleResult;
    }

    public boolean isPushable() {
        return pushable;
    }

    public void setPushable(boolean pushable) {
        this.pushable = pushable;
    }

    public Boolean getWaitForFormId() {
        return waitForFormId;
    }

    public void setWaitForFormId(Boolean waitForFormId) {
        this.waitForFormId = waitForFormId;
    }

    public Long getPushAfterMillis() {
        return pushAfterMillis;
    }

    public void setPushAfterMillis(Long pushAfterMillis) {
        this.pushAfterMillis = pushAfterMillis;
    }
}
