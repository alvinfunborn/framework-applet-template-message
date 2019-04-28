package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.record.PushRecord;
import com.alvin.framework.applet.template.message.service.PushRecorder;

import java.util.List;

/**
 * datetime 2019/4/26 11:48
 *
 * @author sin5
 */
public class TimeWindowPushRuleExecutor extends PushRuleExecutor {

    private PushRecorder pushRecorder;

    public TimeWindowPushRuleExecutor() {
    }

    public TimeWindowPushRuleExecutor withRule(PushRule rule) {
        if (rule instanceof TimeWindowPushRule) {
            this.rules.add(rule);
            return this;
        }
        throw new IllegalArgumentException("rule must be instance of TimeWindowPushRule.class");
    }

    public void setPushRecorder(PushRecorder pushRecorder) {
        this.pushRecorder = pushRecorder;
    }

    public RuleResult pushable(String openId, String business) {
        long now = System.currentTimeMillis();
        for (PushRule rule : rules) {
            List<TimeWindowLimit> limits = ((TimeWindowPushRule) rule).getTimeWindowsLimits();
            for (TimeWindowLimit limit : limits) {
                long timeWindow = limit.getDuration();
                int upperLimit = limit.getUpperLimit();
                int pushCount;
                if (business != null) {
                    pushCount = pushRecorder.countAllByOpenIdAndBusinessAndTimestampBetweenAndSuccessfulIsTrue(openId, business, now - timeWindow, now);
                } else {
                    pushCount = pushRecorder.countAllByOpenIdAndTimestampBetweenAndSuccessfulIsTrue(openId, now - timeWindow, now);
                }
                if (pushCount >= upperLimit) {
                    // not pushable
                    List<PushRecord> pushRecords;
                    if (business != null) {
                        pushRecords = pushRecorder.findTopNByOpenIdAndBusinessAndSuccessfulIsTrueOrderByTimestampDesc(openId, business, upperLimit);
                    } else {
                        pushRecords = pushRecorder.findTopNByOpenIdAndSuccessfulIsTrueOrderByTimestampDesc(openId, upperLimit);
                    }
                    long windowEnd = pushRecords.get(pushRecords.size() - 1).getTimestamp() + timeWindow;
                    return RuleResult.pushAfterMillis(windowEnd - now);
                }
            }
        }
        return RuleResult.pushable();
    }

}
