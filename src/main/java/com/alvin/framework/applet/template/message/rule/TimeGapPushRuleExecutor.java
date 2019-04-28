package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.record.PushRecord;
import com.alvin.framework.applet.template.message.service.PushRecorder;

import java.util.List;

/**
 * datetime 2019/4/26 11:50
 *
 * @author sin5
 */
public class TimeGapPushRuleExecutor extends PushRuleExecutor {

    private PushRecorder pushRecorder;

    public TimeGapPushRuleExecutor() {
    }

    public TimeGapPushRuleExecutor withRule(PushRule rule) {
        if (rule instanceof TimeGapPushRule) {
            this.rules.add(rule);
            return this;
        }
        throw new IllegalArgumentException("rule must be instance of TimeGapPushRule.class");
    }

    public void setPushRecorder(PushRecorder pushRecorder) {
        this.pushRecorder = pushRecorder;
    }

    public RuleResult pushable(String openId, String business) {
        List<PushRecord> records;
        if (business != null) {
            records = pushRecorder.findTopNByOpenIdAndBusinessAndSuccessfulIsTrueOrderByTimestampDesc(openId, business, 1);
        } else {
            records = pushRecorder.findTopNByOpenIdAndSuccessfulIsTrueOrderByTimestampDesc(openId, 1);
        }
        for (PushRule rule : rules) {
            long timeGap = ((TimeGapPushRule) rule).getDuration();
            if (!records.isEmpty()) {
                long timestamp = records.get(0).getTimestamp();
                if (System.currentTimeMillis() - timestamp < timeGap) {
                    return RuleResult.pushAfterMillis(timestamp + timeGap);
                }
            }
        }
        return RuleResult.pushable();
    }
}
