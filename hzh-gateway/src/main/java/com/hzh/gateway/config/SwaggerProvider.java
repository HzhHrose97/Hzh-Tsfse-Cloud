package com.hzh.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合每个服务的接口
 */
@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider, WebFluxConfigurer {

    /**
     * Swagger2默认的url后缀
     */
    private static final String SWAGGER2URL = "/v2/api-docs";


    /**
     * 网关路由
     */
    @Autowired
    private  RouteLocator routeLocator;

    @Autowired
    private GatewayProperties gatewayProperties;

    /**
     * 网关应用名称
     */
    @Value("${spring.application.name}")
    private String self;

    public SwaggerProvider() {
    }


    /**
     * 聚合其他服务接口
     *
     * @return
     */
    @Override
    public List<SwaggerResource> get()
    {
        List<SwaggerResource> resourceList = new ArrayList<>();
        List<String> routes = new ArrayList<>();

        // 获取网关中配置的route
        routeLocator.getRoutes()
                .filter(route -> route.getUri().getHost() != null)
                .filter(route -> !self.equals(route.getUri().getHost()))
                .subscribe(route -> routes.add(route.getId()));

        // 记录已经添加过的server，存在同一个应用注册了多个服务在nacos上
//          .filter(predicateDefinition -> "Path".equalsIgnoreCase(predicateDefinition.getName()))
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .forEach(predicateDefinition -> resourceList.add(
                                swaggerResource(
                                        routeDefinition.getId(),
                                        predicateDefinition
                                                .getArgs()
                                                .get(NameUtils.GENERATED_NAME_PREFIX + "0")
                                                .replace("/**",SWAGGER2URL)
                                )
                        )));
        return resourceList;
    }

    private SwaggerResource swaggerResource(String name, String location)
    {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

    /**
     * 设置静态资源映射(WebMvcConfig类中的addResourceHandlers方法) ,否则接口文档页面无法访问
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        /** swagger-ui 地址 */
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

}

