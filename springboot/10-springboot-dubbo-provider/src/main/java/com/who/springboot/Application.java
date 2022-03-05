package com.who.springboot;


import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
