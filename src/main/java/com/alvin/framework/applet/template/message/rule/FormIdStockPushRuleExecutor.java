package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.formid.FormIdProvider;

/**
 * datetime 2019/4/26 11:50
 *
 * @author sin5
 */
public class FormIdStockPushRuleExecutor extends PushRuleExecutor {

    private FormIdProvider formIdProvider;


    public FormIdStockPushRuleExecutor() {
    }

    public FormIdStockPushRuleExecutor withRule(PushRule rule) {
        if (rule instanceof FormIdStockPushRule) {
            this.rules.add(rule);
            return this;
        }
        throw new IllegalArgumentException("rule must be instance of FormIdStockPushRule.class");
    }

    public void setFormIdProvider(FormIdProvider formIdProvider) {
        this.formIdProvider = formIdProvider;
    }

    public RuleResult pushable(String openId, String business) {
        int formIdCount = formIdProvider.countValidFormId(openId);
        for (PushRule rule : rules) {
            int stock = ((FormIdStockPushRule) rule).getStock();
            if (stock > formIdCount) {
                // not pushable
                return RuleResult.waitForFormId();
            }
        }
        return RuleResult.pushable();
    }
}
