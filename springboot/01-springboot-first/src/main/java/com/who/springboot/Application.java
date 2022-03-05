package com.who.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBoot项目启动入口类
@SpringBootApplication	// spring boot核心注释，用于开启spring自动配置
public class Application {
	// springboot项目代码必须放在Application类所在的同级目录或下级目录

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
