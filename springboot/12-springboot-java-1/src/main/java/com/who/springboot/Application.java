package com.who.springboot;

import com.who.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
		StudentService studentService = (StudentService) configurableApplicationContext.getBean("studentServiceImpl");
		String res = studentService.sayHello();
		System.out.println(res);
	}

}
