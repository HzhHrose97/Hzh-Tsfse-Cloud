package com.hzh.team;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@MapperScan("com.hzh.common.mapper.**")
@SpringBootApplication(scanBasePackages = {"com.hzh.**"} )
public class HzhTeamApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzhTeamApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 球队中心服务启动成功...=================");
    }

}
