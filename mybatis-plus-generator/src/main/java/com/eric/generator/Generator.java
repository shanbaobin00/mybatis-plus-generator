package com.eric.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author shanbb
 * @description
 * @date 2020-03-10
 */
public class Generator {

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();
        // set freemarker engine
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor("eric");
        globalConfig.setOpen(false);
        generator.setGlobalConfig(globalConfig);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/barcode?serverTimezone=UTC&useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.bigdata");
        generator.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        generator.setStrategy(strategy);

        generator.execute();

    }


}
