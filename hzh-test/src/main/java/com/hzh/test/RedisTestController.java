package com.hzh.test;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: redis添加对象测试类
 * @Author: FXS) Hzh
 * @Date: 2023/4/10 15:52
 */
@Slf4j
@MapperScan("com.hzh.common.mapper")
@SpringBootApplication(scanBasePackages = {"com.hzh"} )
public class RedisTestController {



}
