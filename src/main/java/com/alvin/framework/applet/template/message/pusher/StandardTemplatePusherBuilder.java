package com.alvin.framework.applet.template.message.pusher;

import java.util.concurrent.Executors;

/**
 * datetime 2019/4/26 18:21
 *
 * @author sin5
 */
public class StandardTemplatePusherBuilder extends TemplatePusherBuilder {

    @Override
    public StandardTemplatePusher build() {
        if (executorService == null) {
            executorService = Executors.newCachedThreadPool();
        }
        if (appletRepository == null) {
            throw new NullPointerException("appletRepository is null");
        }
        if (httpPoster == null) {
            throw new NullPointerException("httpPoster is null");
        }
        if (pushRecorder == null) {
            throw new NullPointerException("pushRecorder is null");
        }
        if (templateMessageItemRepository == null) {
            throw new NullPointerException("templateMessageItemRepository is null");
        }
        StandardTemplatePusher pusher;
        if (formIdProvider == null) {
            pusher = new StandardTemplatePusher(executorService, appletRepository, httpPoster, pushRecorder, templateMessageItemRepository);
        } else {
            pusher = new StandardTemplatePusher(executorService, appletRepository, httpPoster, pushRecorder, templateMessageItemRepository, formIdProvider);
        }
        ruleExecutors.forEach(pusher::addPushRuleExecutor);
        return pusher;
    }
}
