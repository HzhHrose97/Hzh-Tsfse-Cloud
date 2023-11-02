package com.hzh.test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
/**
 * @Description: Quartz定时任务
 * @Author: FXS) Hzh
 * @Date: 2023/10/11 17:16
 */
public class QuartzExample {
    public static void main(String[] args) {
        try {
            // 创建调度器工厂
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            // 定义JobDetail，包括任务名称和任务组
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                    .withIdentity("myJob", "myJobGroup")
                    .build();

            // 定义触发器，设置定时规则（这里示例每隔2秒执行一次）
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger", "myTriggerGroup")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(2)
                            .repeatForever())
                    .build();

            // 将JobDetail和Trigger关联，安排任务执行
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动调度器
            scheduler.start();

            // 等待一段时间后停止调度器
            Thread.sleep(10000);
            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyJob implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            // 在这里定义任务要执行的操作
            System.out.println("Quartz定时任务执行了！");
        }
    }
}
