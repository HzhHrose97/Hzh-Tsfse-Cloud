package com.hzh.test.mybatisPlus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class CodeGenerator extends AutoGenerator {




    public static void main(String[] args) {
        // 生成器
        AutoGenerator mpg = new AutoGenerator();
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.hzh.common");                // 父包名
        pc.setController("controller");     // Controller包名
        pc.setService("service");           // Service包名
        pc.setServiceImpl("service.impl");  // Service Impl包名
        pc.setMapper("mapper");             // Mapper包名
        pc.setEntity("pojo");             // Entity包名
        pc.setXml("mapper.xml");                        // Mapper XML包名
        mpg.setPackageInfo(pc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setSwagger2(true);         // 开启swagger2模式
        gc.setOutputDir("E:\\my-code\\tsfse\\code\\Hzh-Tsfse-Cloud\\hzh-common\\src\\main\\java");  // 生成文件存放的位置
        gc.setFileOverride(true);     // 是否覆盖已有文件
        gc.setActiveRecord(false);    // 开启ActiveRecord模式,默认false
        gc.setEnableCache(false);     // 是否在xml中添加二级缓存配置,默认false
        gc.setBaseResultMap(true);    // 开启BaseResultMap(通用查询映射结果)
        gc.setBaseColumnList(true);   // 开启baseColumnList(通用查询结果列)
        gc.setAuthor("Hzh");          // 开发人员
        // 自定义文件命名，注意 %s 会自动填充表实体属性(各层文件名称方式，例如：%sAction生成UserAction, %s为占位符)
        gc.setEntityName("%s");
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("5q6W7e8R");
        dsc.setUrl("jdbc:mysql://192.168.65.131:3306/hzh_tsfse_cloud?useOldAliasMetadataBehavior=true&useSSL=false&serverTimezone=GMT");
        dsc.setDbType(DbType.MYSQL);   //数据库类型设置
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(""); // 去掉表名前缀
        strategy.setNaming(NamingStrategy.underline_to_camel); // 表名生成策略(underline_to_camel：下划线转驼峰命名)
        strategy.setInclude("basketball_coach_info"); // 表名  DCustomerBase
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperControllerClass("com.abc.xxx.controller.BaseController");
//        strategy.setSuperEntityClass("com.abc.xxx.entity.BaseEntity");
        strategy.setEntityLombokModel(true);    // 实体类是否为lombok模型(默认false)
        strategy.setRestControllerStyle(true);  // 生成 <code>@RestController</code> 控制器

//        strategy.setSuperControllerClass(null); // 自定义继承的Controller类全称，带包名
        strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper"); // 自定义继承的Mapper类全称，带包名
        mpg.setStrategy(strategy);
        // 执行生成
        mpg.execute();
    }

}

