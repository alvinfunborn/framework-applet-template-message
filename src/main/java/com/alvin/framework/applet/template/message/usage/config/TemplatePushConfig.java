package com.alvin.framework.applet.template.message.usage.config;

import com.alvin.framework.applet.template.message.formid.StandardFormIdProvider;
import com.alvin.framework.applet.template.message.pusher.StandardTemplatePusherBuilder;
import com.alvin.framework.applet.template.message.pusher.TemplatePusher;
import com.alvin.framework.applet.template.message.pusher.TemplatePusherBuilder;
import com.alvin.framework.applet.template.message.rule.*;
import com.alvin.framework.applet.template.message.service.AppletRepository;
import com.alvin.framework.applet.template.message.service.HttpPoster;
import com.alvin.framework.applet.template.message.service.PushRecorder;
import com.alvin.framework.applet.template.message.service.TemplateMessageItemRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * datetime 2019/4/28 10:31
 *
 * @author sin5
 */
public class TemplatePushConfig {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private AppletRepository appletRepository;
    private HttpPoster httpPoster;
    private PushRecorder pushRecorder;
    private TemplateMessageItemRepository templateMessageItemRepository;

    public TemplatePusher templatePusher() {
        TemplatePusherBuilder pusherBuilder = new StandardTemplatePusherBuilder()
                .withAppletRepository(appletRepository)
                .withFormIdProvider(new StandardFormIdProvider())
                .withHttpPoster(httpPoster)
                .withPushRecorder(pushRecorder)
                .withExecutorService(EXECUTOR_SERVICE)
                .withTemplateMessageItemRepository(templateMessageItemRepository);

        pusherBuilder.addPushRuleExecutor(new TimeWindowPushRuleExecutor()
                .withRule(TimeWindowPushRule.ofGlobal().addTimeWindow(1, TimeUnit.MINUTES, 1)
                        .addTimeWindow(2, TimeUnit.HOURS, 10))
                .withRule(TimeWindowPushRule.ofBusiness("bus1").addTimeWindow(12, TimeUnit.HOURS, 10)));
        pusherBuilder.addPushRuleExecutor(new TimeGapPushRuleExecutor()
                .withRule(TimeGapPushRule.ofBusiness("bus1", true, 12, TimeUnit.SECONDS)));
        pusherBuilder.addPushRuleExecutor(new FormIdStockPushRuleExecutor()
                .withRule(FormIdStockPushRule.ofGlobal(3)));
        return pusherBuilder.build();
    }
}
