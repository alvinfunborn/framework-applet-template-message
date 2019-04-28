package com.alvin.framework.applet.template.message.service;

import com.alvin.framework.applet.template.message.record.PushRecord;
import com.alvin.framework.applet.template.message.annotation.NotNull;

import java.util.List;

/**
 * datetime 2019/4/26 17:07
 *
 * @author sin5
 */
public interface PushRecorder {

    void record(@NotNull String messageId, @NotNull String openId, String business, boolean successful, String errmsg, long timestamp);

    int countAllByOpenIdAndBusinessAndTimestampBetweenAndSuccessfulIsTrue(@NotNull String openId, @NotNull String business, long start, long end);

    int countAllByOpenIdAndTimestampBetweenAndSuccessfulIsTrue(@NotNull String openId, long start, long end);

    List<PushRecord> findTopNByOpenIdAndBusinessAndSuccessfulIsTrueOrderByTimestampDesc(@NotNull String openId, @NotNull String business, int limit);

    List<PushRecord> findTopNByOpenIdAndSuccessfulIsTrueOrderByTimestampDesc(@NotNull String openId, int limit);
}
