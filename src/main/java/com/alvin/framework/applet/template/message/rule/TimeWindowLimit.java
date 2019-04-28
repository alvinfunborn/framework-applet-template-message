package com.alvin.framework.applet.template.message.rule;

/**
 * datetime 2019/4/26 16:41
 *
 * @author sin5
 */
public class TimeWindowLimit {

    private long duration;
    private int upperLimit;

    TimeWindowLimit(long duration, int upperLimit) {
        this.duration = duration;
        this.upperLimit = upperLimit;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }
}
