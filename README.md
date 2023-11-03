# 工程简介
1.该工程为《体育赛事售票管理系统》

2.共有以下几个模块

    hzh-centre     中心模块，负责提供一些公共和远程调用接口
    hzh-common     公共模块，负责一些pojo、utils、mapper、xml、统一结果包装类
    hzh-event      赛事中心，负责发布、记录、策划所有赛事
    hzh-gateway    网关中心，负责对外来请求过滤，以及设备与路由器之间的桥梁，由它将不同的网络间进行访问的控制，转换，交接等等。
    hzh-order      订单模块，负责所有订单业务
    hzh-team       球队中心，负责所有类型的球队统计
    hzh-test       测试模块，负责做一些测试
    hzh-user       用户中心，负责做权限校验、登录验证、注册

3.该工程设计技术栈及其版本信息
    
    java 11
    java-mail 
    nacos 1.3.2
    redis 2.6.7
    mysql 8.0.27
    mybatis 2.1.1
    tomcat 9.0.69
    swagger 2.9.2
    mybatis-plus 3.4.1
    spring-boot 2.3.12.RELEASE
    spring-cloud Hoxton.SR10
    spring-cloud-agteway 2.2.7.RELEASE
    spring-cloud-alibaba 2.2.5.RELEASE
    rocketmq 4.9.4
    
4.Spring Cloud项目Gateway统一管理swagger接口

统一访问接口
    http://localhost:6029/swagger-ui.html

# 延伸阅读

1.mybatisPlus 自动生成代码需要配置mybatis-plus版本为3.4.1之外的全都不可以
2.该项目会集成java-mial 用来做注册验证

# 版本对应
1.springcloud 体系版本对应

官网查看
https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-Hoxton-Release-Notes#hoxtonsr10

Hoxton.SR10
2021-02-11

See all of the included issues and pull requests at the GitHub project. Hoxton.SR10 is compatible with Spring Boot 2.3.x and 2.2.x.

Spring Cloud Gateway 2.2.7.RELEASE (issues)
Spring Cloud Starter Build Hoxton.SR10
Spring Cloud Aws 2.2.6.RELEASE (issues)
Spring Cloud Cli 2.2.4.RELEASE
Spring Cloud Sleuth 2.2.7.RELEASE (issues)
Spring Cloud Vault 2.2.7.RELEASE (issues)
Spring Cloud Openfeign 2.2.7.RELEASE (issues)
Spring Cloud Commons 2.2.7.RELEASE (issues)
Spring Cloud Kubernetes 1.1.8.RELEASE
Spring Cloud Config 2.2.7.RELEASE (issues)
Spring Cloud Contract 2.2.6.RELEASE (issues)
Spring Cloud Netflix 2.2.7.RELEASE (issues)
Spring Cloud Consul 2.2.6.RELEASE (issues)
Spring Cloud Gcp 1.2.7.RELEASE

# DB备份

    hzh_tsfse_cloud.sql

# 单独依赖问题
1.hzh-user 需要java-mail

2.hzh-gateway 需要spring-cloud-starter-gateway

# 关于openFeign依赖引入

spring-cloud-starter-openfeign、feign-core、feign-okhttp、feign-hystrix、hystrix-core 这些依赖的关系和作用如下：

spring-cloud-starter-openfeign：是 Spring Cloud 对 OpenFeign 进行封装的依赖，包含了 OpenFeign 的核心库以及一些必要的配置。

feign-core：是 OpenFeign 的核心库，提供了使用 Feign 构建 REST 客户端的基础功能。

feign-okhttp：是 OpenFeign 集成 OkHttp 的依赖，提供了使用 OkHttp 作为 Feign 的底层 HTTP 客户端的能力。

feign-hystrix：是 OpenFeign 集成 Hystrix 的依赖，提供了使用 Hystrix 实现服务的容错和熔断能力。

hystrix-core：是 Hystrix 的核心库，提供了 Hystrix 的基础功能。

如果引入了 spring-cloud-starter-openfeign，则已经包含了 feign-core、feign-okhttp 和 feign-hystrix 依赖。而 hystrix-core 由 feign-hystrix 自动依赖，因此在这种情况下不需要显式引入 feign-core、feign-okhttp、feign-hystrix 和 hystrix-core 依赖。


# 关于mybatis-plus依赖引入

MyBatis-Plus是基于MyBatis的增强工具，它提供了多个模块，其主要模块及其作用如下：

mybatis-plus-core：MyBatis-Plus的核心模块，提供基本的CRUD操作和一些扩展功能。

mybatis-plus-extension：MyBatis-Plus的扩展模块，提供了一些额外的功能，如分页插件、性能分析插件等。

mybatis-plus-annotation：MyBatis-Plus的注解模块，提供了一些注解，如自动填充注解、条件注解等，可以简化代码开发。

mybatis-plus-generator：MyBatis-Plus的代码生成器模块，可以根据数据库表结构自动生成对应的Java类和XML文件。

这些模块都是独立的，可以根据需要进行引入。通常情况下，如果只需要进行基本的CRUD操作，只需要引入mybatis-plus-core模块即可。如果需要使用一些额外的功能，如分页插件等，需要引入mybatis-plus-extension模块。如果需要使用MyBatis-Plus的注解功能，则需要引入mybatis-plus-annotation模块。如果需要使用MyBatis-Plus的代码生成器，则需要引入mybatis-plus-generator模块。需要注意的是，如果需要使用代码生成器，则需要同时引入mybatis-plus-core和mybatis-plus-generator两个模块。
# 问题记录(exclusions 不生效问题)
1.父工程中具有这两个依赖，且子工程除hzh-gateway都需要，但是因为 exclusions 标签不生效所以只能在父工程中注释
    具体的子工程需要依赖，单独添加以下两个依赖
2.后续该问题解决后会在hzh-centre、hzh-event、hzh-order、hzh-team、hzh-user模块中去掉  mybatis-spring-boot-starter 依赖

        网关中不需要的依赖  spring-boot-starter-web   和  mybatis-spring-boot-starter

FeignConfig应该配置在消费者模块



# rocketmq 相关配置
rocketmq-spring-boot-starter 2.2.0及其以上版本，配置是这样的：

    #rocketmq相关配置
    rocketmq.nameServer=RocketMq服务IP地址:9876
    rocketmq.producer.group=组id


现在的情况是Hzh-Centre 中心模块做了生产者，生产了消息，最重要的一条是 同步消息，没有被其他模块的消费者消费


# 运维部署
1.关于jdk环境，除tsfse项目以外均使用jdk8,所以在各个子模块的start.sh文件中需要指定jdk11路径地址
2.日志文件的配置信息以及项目配置信息均在conf文件下
3.hzh-order 无法启动（开发环境）

# 常见问题以及处理
1. 关于installinstall时无法加载到common依赖从而无法生成jar包  
   原因： 根项目的pom文件中加入了以下依赖导致其他模块在


    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <version>2.3.12.RELEASE</version>
    </plugin>-->





