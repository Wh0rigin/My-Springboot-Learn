package com.who.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		关闭logo
//		SpringApplication springApplication = new SpringApplication(Application.class);
//		springApplication.setBannerMode(Banner.Mode.OFF); // 关闭logo
//		springApplication.run(args);
		SpringApplication.run(Application.class, args);
	}

}
