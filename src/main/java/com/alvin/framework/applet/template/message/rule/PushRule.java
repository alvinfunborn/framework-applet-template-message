package com.alvin.framework.applet.template.message.rule;

/**
 * datetime 2019/4/26 11:41
 *
 * @author sin5
 */
public class PushRule {

    /**
     * business of rule
     */
    protected String business;
    /**
     * if business is independent, independent business rule is not influenced by global rules
     */
    private boolean independent = false;

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public boolean isIndependent() {
        return independent;
    }

    void setIndependent(boolean independent) {
        this.independent = independent;
    }
}
