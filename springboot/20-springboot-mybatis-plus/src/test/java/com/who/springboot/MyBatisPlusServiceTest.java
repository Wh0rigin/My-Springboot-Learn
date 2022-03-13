package com.who.springboot;

import com.who.springboot.pojo.User;
import com.who.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("总记录数:"+count);
    }

    @Test
    public void testInsertOne(){
        User user = new User();
        user.setId(6L);
        user.setName("张三");
        user.setAge(19);
        user.setEmail("123@123.com");
        userService.save(user);
    }

    @Test
    public void testList(){
        List<User> users = userService.list();
        users.forEach(System.out::println);
    }

    @Test
    public void testInsertMore(){
        List<User> users = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            User user = new User();
            user.setName("test"+i);
            user.setAge(20+i);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);
    }

    @Test
    public void testDeleteTest(){
        for (int i = 0;i < 10;i++){
            Map<String,Object> re = new HashMap<>();
            re.put("name", "test"+i);
            userService.removeByMap(re);
        }
    }

    @Test
    public void testDelete(){
        Map<String,Object> re = new HashMap<>();
        re.put("name", "张三");
        userService.removeByMap(re);
    }
}
