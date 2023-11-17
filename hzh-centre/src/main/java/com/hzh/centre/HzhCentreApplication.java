package com.hzh.centre;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@EnableDiscoveryClient
@MapperScan("com.hzh.common.mapper.**")
@SpringBootApplication(scanBasePackages = {"com.hzh.**"} )
public class HzhCentreApplication implements WebMvcConfigurer {

    public static void main(String[] args) throws Exception {
      SpringApplication.run(HzhCentreApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 共享中心服务启动成功...=================");
    }



}
