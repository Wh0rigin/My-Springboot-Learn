package com.who.springamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;


	@Test
	void contextLoads() {
		HashMap<String,String> user= new HashMap<>();
		user.put("name","Wh0rigin");
		user.put("password","123456");
		rabbitTemplate.convertAndSend("convert.queue1",user);
	}

}
