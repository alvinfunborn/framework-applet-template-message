package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.annotation.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * datetime 2019/4/26 11:45
 *
 * @author sin5
 */
public class TimeGapPushRule extends PushRule {

    private long duration;

    public long getDuration() {
        return duration;
    }

    private void setDuration(long duration) {
        this.duration = duration;
    }

    public static TimeGapPushRule ofBusiness(@NotNull String business, boolean independent, long duration, TimeUnit timeUnit) {
        if (duration <= 0) {
            throw new IllegalArgumentException("duration must be larger than zero");
        }
        TimeGapPushRule rule = new TimeGapPushRule();
        rule.setBusiness(business);
        rule.setIndependent(independent);
        rule.setDuration(timeUnit.toMillis(duration));
        return rule;
    }

    public static TimeGapPushRule ofBusiness(@NotNull String business, long duration, TimeUnit timeUnit) {
        if (duration <= 0) {
            throw new IllegalArgumentException("duration must be larger than zero");
        }
        TimeGapPushRule rule = new TimeGapPushRule();
        rule.setBusiness(business);
        rule.setDuration(timeUnit.toMillis(duration));
        return rule;
    }

    public static TimeGapPushRule ofGlobal(long duration, TimeUnit timeUnit) {
        if (duration <= 0) {
            throw new IllegalArgumentException("duration must be larger than zero");
        }
        TimeGapPushRule rule = new TimeGapPushRule();
        rule.setDuration(timeUnit.toMillis(duration));
        return rule;
    }
}
