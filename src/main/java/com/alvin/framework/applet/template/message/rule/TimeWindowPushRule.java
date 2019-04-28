package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * datetime 2019/4/26 11:42
 *
 * @author sin5
 */
public class TimeWindowPushRule extends PushRule {
    
    private List<TimeWindowLimit> timeWindowsLimits = new ArrayList<>();

    public List<TimeWindowLimit> getTimeWindowsLimits() {
        return timeWindowsLimits;
    }

    public static TimeWindowPushRule ofBusiness(@NotNull String business, boolean independent) {
        TimeWindowPushRule rule = new TimeWindowPushRule();
        rule.setBusiness(business);
        rule.setIndependent(independent);
        return rule;
    }

    public static TimeWindowPushRule ofBusiness(@NotNull String business) {
        TimeWindowPushRule rule = new TimeWindowPushRule();
        rule.setBusiness(business);
        return rule;
    }

    public static TimeWindowPushRule ofGlobal() {
        return new TimeWindowPushRule();
    }

    public TimeWindowPushRule addTimeWindow(long duration, TimeUnit timeUnit, int upperLimit) {
        if (duration <= 0) {
            throw new IllegalArgumentException("duration must be larger than zero");
        }
        if (upperLimit <= 0) {
            throw new IllegalArgumentException("upperLimit must be larger than zero");
        }
        this.timeWindowsLimits.add(new TimeWindowLimit(timeUnit.toMillis(duration), upperLimit));
        return this;
    }
}
