package com.who.springboot;

import com.who.springboot.mapper.UserMapper;
import com.who.springboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UserMapper userMapper;


	@Test
	void contextLoads() {
	}


	@Test
	public void testSelectList(){
		// 通过 条件构造器查询一个list集合，若没有条件，则可以设置null为参数
		List<User> list = userMapper.selectList(null);
		list.forEach(System.out::println);
 	}

	 @Test
	public void testIntsert(){
		// 实现新增用户信息
		User user = new User();
		user.setName("张三");
		user.setAge(19);
		user.setEmail("123@qwe.com");
		int result = userMapper.insert(user);
		 System.out.println("result:"+result);
		 System.out.println("id:"+user.getId());
	 }

	 @Test
	public void testdelete(){
		// way 1
//		int res = userMapper.deleteById(1500363122291060738L);
//		System.out.println("result:" + res);
		// way 2
		 Map<String,Object> map= new HashMap<>();
		 map.put("name","张三");
		 userMapper.deleteByMap(map);

	 }
}
