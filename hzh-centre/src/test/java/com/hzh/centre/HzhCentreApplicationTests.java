package com.hzh.centre;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HzhCentreApplicationTests {
    @Value("${mybatis-plus.mapper-locations}")
    public  String mybatisPlusss;
    @Test
    void contextLoads() {
        System.out.println(mybatisPlusss);
    }

}
