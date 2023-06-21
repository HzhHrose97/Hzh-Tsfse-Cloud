package com.hzh.centre;

//import com.hzh.centre.rocketmq.AsyncProducer;
import com.hzh.centre.handler.LoggingInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@MapperScan("com.hzh.common.mapper.**")
@SpringBootApplication(scanBasePackages = {"com.hzh.**"} )
public class HzhCentreApplication implements WebMvcConfigurer {

    public static void main(String[] args) throws Exception {
        //AsyncProducer asyncProducer = new AsyncProducer();
        //asyncProducer.sendMessage("Centre","Centre-Test","Centre-1", "Hello world, 这是一条异步消息".getBytes());
        SpringApplication.run(HzhCentreApplication.class, args);
        log.info("=================Hzh-Tsfse-Cloud 共享中心服务启动成功...=================");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor());
    }

    // 拦截到rul 并输出在控制台
    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

}
