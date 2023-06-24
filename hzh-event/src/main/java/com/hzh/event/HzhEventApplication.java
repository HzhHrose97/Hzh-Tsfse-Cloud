package com.hzh.event;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@EnableAspectJAutoProxy
@MapperScan("com.hzh.common.mapper.**")
@SpringBootApplication(scanBasePackages = {"com.hzh.**"} )
public class HzhEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzhEventApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 赛事中心服务启动成功...=================");
    }

}
