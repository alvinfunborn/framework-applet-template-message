package com.alvin.framework.applet.template.message.rule;

import com.alvin.framework.applet.template.message.annotation.NotNull;

/**
 * datetime 2019/4/26 11:49
 *
 * @author sin5
 */
public class FormIdStockPushRule extends PushRule {

    /**
     * push only when number of formId is large than equal stock
     */
    private int stock;

    public int getStock() {
        return stock;
    }

    private void setStock(int stock) {
        this.stock = stock;
    }

    public static FormIdStockPushRule ofBusiness(@NotNull String business, boolean independent, int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("stock must be larger than zero");
        }
        FormIdStockPushRule rule = new FormIdStockPushRule();
        rule.setBusiness(business);
        rule.setIndependent(independent);
        rule.setStock(stock);
        return rule;
    }

    public static FormIdStockPushRule ofBusiness(@NotNull String business, int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("stock must be larger than zero");
        }
        FormIdStockPushRule rule = new FormIdStockPushRule();
        rule.setBusiness(business);
        rule.setStock(stock);
        return rule;
    }

    public static FormIdStockPushRule ofGlobal(int stock) {
        if (stock <= 0) {
            throw new IllegalArgumentException("stock must be larger than zero");
        }
        FormIdStockPushRule rule = new FormIdStockPushRule();
        rule.setStock(stock);
        return rule;
    }
}
