package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * datetime 2019/4/26 11:37
 *
 * @author sin5
 */
public abstract class PushRuleExecutor {

    /**
     * rule list
     */
    protected List<PushRule> rules = new ArrayList<>();

    /**
     * check if pushable
     *
     * @param openId openId
     * @param business business
     * @return RuleResult
     */
    public abstract RuleResult pushable(@NotNull String openId, String business);

}
