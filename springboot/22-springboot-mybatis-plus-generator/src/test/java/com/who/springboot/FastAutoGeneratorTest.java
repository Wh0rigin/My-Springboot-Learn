package com.who.springboot;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class FastAutoGeneratorTest {


    @Test
    public void autoGeneratoer(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=false"
                ,"root","123456")
                .globalConfig(builder -> {
                    builder.author("who")
                            .fileOverride()
                            .outputDir("src/main/java"); //输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.who.springboot")
                            .moduleName("mybatis")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,"src/main/java"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user")
                            .addTablePrefix(""); // 设置过滤其表前缀
                    // 如t_user 过滤其表前缀t_生成user
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
