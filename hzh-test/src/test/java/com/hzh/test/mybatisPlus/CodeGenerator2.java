package com.hzh.test.mybatisPlus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @Description:
 * @Author: FXS) Hzh
 * @Date: 2023/3/27 16:32
 */
public class CodeGenerator2 {

     public static void main(String[] args) {
        // 1、创建代码生成器
         AutoGenerator mpg = new AutoGenerator();

         // 2、全局配置
         GlobalConfig gc = new GlobalConfig();
         String projectPath = System.getProperty("user.dir");
         // 此处建议写项目/src/main/java源代码的绝对路径
         gc.setOutputDir("E:\\my-code\\tsfse\\code\\Hzh-Tsfse-Cloud\\hzh-common\\src\\main\\java");  // 生成文件存放的位置
         // 生成注释时的作者
         gc.setAuthor("Hzh");          // 开发人员
         //生成后是否打开资源管理器
         gc.setOpen(false);
         gc.setIdType(IdType.ID_WORKER_STR); //主键策略
         gc.setDateType(DateType.ONLY_DATE); //定义生成的实体类中日期类型
         // 如果开启Swagger,要引入相应的包
         gc.setSwagger2(true);         // 开启swagger2模式
         gc.setFileOverride(true);     // 是否覆盖已有文件
         gc.setActiveRecord(false);    // 开启ActiveRecord模式,默认false
         gc.setEnableCache(true);     // 是否在xml中添加二级缓存配置,默认false
         gc.setBaseResultMap(true);    // 开启BaseResultMap(通用查询映射结果)
         gc.setBaseColumnList(true);   // 开启baseColumnList(通用查询结果列)
         // 自定义文件命名，注意 %s 会自动填充表实体属性(各层文件名称方式，例如：%sAction生成UserAction, %s为占位符)
         gc.setEntityName("%s");
         gc.setControllerName("%sController");
         gc.setServiceName("%sService");
         gc.setServiceImplName("%sServiceImpl");
         gc.setMapperName("%sMapper");
         gc.setXmlName("%sMapper");

         mpg.setGlobalConfig(gc);

         // 3、数据源配置
         DataSourceConfig dsc = new DataSourceConfig();
         dsc.setDriverName("com.mysql.cj.jdbc.Driver");
         dsc.setUsername("root");
         dsc.setPassword("5q6W7e8R");
         dsc.setUrl("jdbc:mysql://192.168.65.131:3306/hzh_tsfse_cloud?useOldAliasMetadataBehavior=true&useSSL=false&serverTimezone=GMT");
         dsc.setDbType(DbType.MYSQL);   //数据库类型设置
         mpg.setDataSource(dsc);


         // 4、包配置
         PackageConfig pc = new PackageConfig();
         // 此处要注意：parent + moduleName 为包的名字，在这个包下，创建对应的controller...
         pc.setParent("com.hzh.common");
         //pc.setModuleName(hzh-common); //模块名
         pc.setController("controller");
         pc.setEntity("pojo.user");
         pc.setService("service");
         pc.setServiceImpl("service.impl");
         pc.setMapper("mapper.user");
         pc.setXml("mapper.xml.user");
         mpg.setPackageInfo(pc);

         // 5、策略配置
         StrategyConfig strategy = new StrategyConfig();
         // 数据库中表的名字，表示要对哪些表进行自动生成controller service、mapper...
         strategy.setInclude("hzh_user","hzh_role","hzh_user_token");
         // 数据库表映射到实体的命名策略,驼峰命名法
         strategy.setNaming(NamingStrategy.underline_to_camel);
         // 生成实体时去掉表前缀，比如edu_course，如果不加下面这句，生成的实体类名字就是：EduCourse
         //strategy.setTablePrefix("");
         //生成实体时去掉表前缀
         // strategy.setTablePrefix(pc.getModuleName() + "_");


         //数据库表字段映射到实体的命名策略
         strategy.setColumnNaming(NamingStrategy.underline_to_camel);
         strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

         strategy.setRestControllerStyle(true); //restful api风格控制器
         strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

         mpg.setStrategy(strategy);

         // 6、执行
         mpg.execute();

    }

}
