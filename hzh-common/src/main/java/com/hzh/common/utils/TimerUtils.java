package com.hzh.common.utils;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/**
 * @Description: java定时器
 * @Author: FXS) Hzh
 * @Date: 2023/10/11 15:25
 */
public class TimerUtils {
    private ScheduledExecutorService scheduler;

    public TimerUtils() {
        // 创建ScheduledExecutorService实例
        scheduler = Executors.newScheduledThreadPool(1);
    }

    public void scheduleTask(Runnable task, long delayMs) {
        // 使用ScheduledExecutorService来执行任务
        ScheduledFuture<?> scheduledFuture = scheduler.scheduleWithFixedDelay(task, 0, delayMs, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        // 停止定时器
        scheduler.shutdown();
    }

}
