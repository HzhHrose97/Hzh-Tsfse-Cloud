package com.hzh.common.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: SwaggerConfig
 */
@Configuration
//@EnableOpenApi
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
        //Swagger 2と同様に、主にドケットで構成されています
    Docket docket(){
        //DocumentationType.OAS_30,原Swagger2选择DocumentationType.SWAGGER_2
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //通过apis方法配置要扫描的controller的位置
                //通过指定controller的路径来
                //.apis(RequestHandlerSelectors.basePackage("com.hzh.*.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //通过paths方法配置路径
                .paths(PathSelectors.any())
                //设置需要排除的路径(如果需要)
                //.paths(Predicate.not(PathSelectors.regex("/error.*")))
                .build().apiInfo(new ApiInfoBuilder()
                        //设置文档标题
                        .description("Hzh_Tsfse_cloud 聚合接口测试UI")
                        //设置联系人信息
                        .contact(new Contact("Hzh","https://www.csdn.net","Hrose97@163.com"))
                        //设置版本号
                        .version("1.1")
                        //设置文档抬头
                        .title("API测试文档")
                        //设置授权
                        .license("License By Hzh")
                        //设置授权访问网址
                        .licenseUrl("https://swagger.io")
                        .build());
    }
    @Override
    //swagger-ui/index.html在META-INF/resources下面,添加资源映射确保URL能够访问
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/swagger-ui/**").addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);

    }

}
