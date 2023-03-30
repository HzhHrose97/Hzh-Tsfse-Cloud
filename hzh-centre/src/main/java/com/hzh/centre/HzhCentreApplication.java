package com.hzh.centre;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@MapperScan("com.hzh.common.mapper.**")
@SpringBootApplication(scanBasePackages = {"com.hzh.**"} )
public class HzhCentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzhCentreApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 共享中心服务启动成功...=================");
    }

}
