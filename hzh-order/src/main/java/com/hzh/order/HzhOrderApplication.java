package com.hzh.order;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@Slf4j
@MapperScan("com.hzh.common.mapper.**")
@SpringBootApplication(scanBasePackages = {"com.hzh.**"} )
@EnableFeignClients(basePackages = "com.hzh.common.openfiegn.**")
public class HzhOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzhOrderApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 订单中心服务启动成功...=================");
    }

}




