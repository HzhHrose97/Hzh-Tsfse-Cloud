package com.hzh.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HzhEventApplicationTests {

    @Value("${spring.rocketmq.name-server}")
    private String nameServer;
    @Test
    void contextLoads() {
    System.out.println("Starting HzhEventApplication == " +  nameServer);
    }

}
