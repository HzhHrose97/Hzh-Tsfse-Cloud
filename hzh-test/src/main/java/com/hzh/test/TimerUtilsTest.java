package com.hzh.test;

import com.hzh.common.utils.TimerUtils;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



/**
 * @Description: 定时器测试类
 * @Author: FXS) Hzh
 * @Date: 2023/10/11 15:28
 */
public class TimerUtilsTest {

    public static void main(String[] args) {
        TimerUtils timer = new TimerUtils();

        timer.scheduleTask(() -> {
            // 获取当前时间
            LocalDateTime currentTime = LocalDateTime.now();

            // 创建一个自定义的日期时间格式
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // 格式化为字符串
            String formattedTime = currentTime.format(formatter);
            System.out.println("定时器TimerUtils test started: " + formattedTime );
        },5000);

    }


}
