package com.example.demo.mbs;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis plus generator
 */

public class Generator {

    public static void main(String[] args) {

        // 创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 控制 不生成 controller以及service时使用
        // 配置模板
        //不需要用时不需要TemplateConfig对象
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("");
        //templateConfig.setService("");
        //templateConfig.setServiceImpl("");
        mpg.setTemplate(templateConfig);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath+"/src/main/java/");

        // 此处建议写项目/src/main/java源代码的绝对路径
        gc.setOutputDir(projectPath + "/src/main/java/");
        //生成后是否打开资源管理器
        gc.setOpen(false);
        //重新生成时文件是否覆盖
        gc.setFileOverride(false);
        //生成swagger相关注解
        gc.setSwagger2(true);
        //类名设置
        gc.setControllerName("%sCtr");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/m1");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("!Qazxsw2");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.demo.mbs.m1");
        pc.setController("controller");
        pc.setEntity("model");
        pc.setService("service");
        pc.setMapper("dao");
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 数据库中表的名字，表示要对哪些表进行自动生成controller service、mapper...
        LikeTable likeTable = new LikeTable("oauth_");
        strategy.setNotLikeTable(likeTable);
        //strategy.setExclude("clientdetails");
        // 数据库表映射到实体的命名策略,驼峰命名法
        strategy.setNaming(NamingStrategy.underline_to_camel);

        //数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        //restful api风格控制器
        strategy.setRestControllerStyle(true);
        //url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //生成model基类
        strategy.setSuperEntityClass(BaseModel.class);
        //数据库中的字段名称
        strategy.setSuperEntityColumns("create_time");
        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();
    }
}
