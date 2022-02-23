package com.who.springboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.who.springboot.mapper")
@EnableDubbo
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
