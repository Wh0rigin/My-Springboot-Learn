package com.who.springboot;

import com.who.springboot.pojo.Product;
import com.who.springboot.pojo.User;
import com.who.springboot.services.ProductService;
import com.who.springboot.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
	}


	@Test
	void list(){
		System.out.println("---------------------------多数据源检测------------------------------");
		List<User> users =  userService.list();
		users.forEach(System.out::println);
		System.out.println("-----------------------");
		List<Product> products = productService.list();
		products.forEach(System.out::println);
	}
}
