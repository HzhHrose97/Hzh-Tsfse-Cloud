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

# 问题记录(exclusions 不生效问题)
1.父工程中具有这两个依赖，且子工程除hzh-gateway都需要，但是因为 exclusions 标签不生效所以只能在父工程中注释
    具体的子工程需要依赖，单独添加以下两个依赖
2.后续该问题解决后会在hzh-centre、hzh-event、hzh-order、hzh-team、hzh-user模块中去掉  mybatis-spring-boot-starter 依赖

        网关中不需要的依赖  spring-boot-starter-web   和  mybatis-spring-boot-starter
        

