package com.alvin.framework.applet.template.message.pusher;

import com.alvin.framework.applet.template.message.formid.FormIdProvider;
import com.alvin.framework.applet.template.message.formid.StandardFormIdProvider;
import com.alvin.framework.applet.template.message.rule.FormIdStockPushRuleExecutor;
import com.alvin.framework.applet.template.message.rule.PushRuleExecutor;
import com.alvin.framework.applet.template.message.rule.TimeGapPushRuleExecutor;
import com.alvin.framework.applet.template.message.rule.TimeWindowPushRuleExecutor;
import com.alvin.framework.applet.template.message.service.AppletRepository;
import com.alvin.framework.applet.template.message.service.HttpPoster;
import com.alvin.framework.applet.template.message.service.PushRecorder;
import com.alvin.framework.applet.template.message.service.TemplateMessageItemRepository;
import com.alvin.framework.applet.template.message.annotation.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * datetime 2019/4/26 18:05
 *
 * @author sin5
 */
public abstract class TemplatePusherBuilder {

    protected ExecutorService executorService;
    protected List<PushRuleExecutor> ruleExecutors = new ArrayList<>();
    protected AppletRepository appletRepository;
    protected HttpPoster httpPoster;
    protected PushRecorder pushRecorder;
    protected TemplateMessageItemRepository templateMessageItemRepository;
    protected FormIdProvider formIdProvider;

    public abstract StandardTemplatePusher build();

    public TemplatePusherBuilder withExecutorService(@NotNull ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    public TemplatePusherBuilder withAppletRepository(@NotNull AppletRepository appletRepository) {
        this.appletRepository = appletRepository;
        if (this.formIdProvider instanceof StandardFormIdProvider) {
            ((StandardFormIdProvider) this.formIdProvider).setAppletRepository(appletRepository);
        }
        return this;
    }

    public TemplatePusherBuilder withHttpPoster(@NotNull HttpPoster httpPoster) {
        this.httpPoster = httpPoster;
        return this;
    }

    public TemplatePusherBuilder withPushRecorder(@NotNull PushRecorder pushRecorder) {
        this.pushRecorder = pushRecorder;
        return this;
    }

    public TemplatePusherBuilder withTemplateMessageItemRepository(@NotNull TemplateMessageItemRepository repository) {
        this.templateMessageItemRepository = repository;
        return this;
    }

    public TemplatePusherBuilder withFormIdProvider(@NotNull FormIdProvider formIdProvider) {
        this.formIdProvider = formIdProvider;
        if (formIdProvider instanceof StandardFormIdProvider && this.appletRepository != null) {
            ((StandardFormIdProvider) this.formIdProvider).setAppletRepository(appletRepository);
        }
        return this;
    }

    public void addPushRuleExecutor(@NotNull PushRuleExecutor pushRuleExecutor) {
        this.ruleExecutors.add(pushRuleExecutor);
        if (pushRuleExecutor instanceof TimeWindowPushRuleExecutor && this.pushRecorder != null) {
            ((TimeWindowPushRuleExecutor) pushRuleExecutor).setPushRecorder(this.pushRecorder);
        } else if (pushRuleExecutor instanceof TimeGapPushRuleExecutor && this.pushRecorder != null) {
            ((TimeGapPushRuleExecutor) pushRuleExecutor).setPushRecorder(this.pushRecorder);
        } else if (pushRuleExecutor instanceof FormIdStockPushRuleExecutor) {
            if (this.formIdProvider != null) {
                ((FormIdStockPushRuleExecutor) pushRuleExecutor).setFormIdProvider(formIdProvider);
            } else {
                ((FormIdStockPushRuleExecutor) pushRuleExecutor).setFormIdProvider(new StandardFormIdProvider());
            }
        }
    }
}
