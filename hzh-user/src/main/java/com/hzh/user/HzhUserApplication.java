package com.hzh.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@MapperScan("com.hzh.common.mapper")
@SpringBootApplication(scanBasePackages = {"com.hzh"} )
public class HzhUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzhUserApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 用户中心服务启动成功...=================");
    }

}
