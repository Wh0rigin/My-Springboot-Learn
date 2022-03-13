package com.who.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.who.springboot.mapper.UserMapper;
import com.who.springboot.pojo.User;
import com.who.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusWapperTest {

    // 组装条件查询

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void mapperSearch(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 查询年龄20-30的用户
        queryWrapper.between("age",20,30);

        userMapper.selectList(queryWrapper);
    }

    @Test
    public void seriveSearch(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 以J为开头的用户
        queryWrapper.like("name","J%");
        userService.list(queryWrapper);
    }

    @Test
    public void moreSeriveSearch(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","J%").gt("age",18);
        userService.list(queryWrapper);
    }


    // 排序
    @Test
    public void orderBySeriveSearch(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        userService.list(queryWrapper);
    }


    // 逻辑删除email为空的数据
    @Test
    public void deleteBySerive(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        userService.remove(queryWrapper);
    }

    @Test
    public void update(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小明");
        user.setEmail("test@123.com");
        userService.update(user,queryWrapper);
    }

    // 带条件优先级的查询
    // lambda表达式中的先执行
    @Test
    public void test00(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(i->i.gt("age",20)
                        .or()
                        .isNull("email"));
        //User user = new User();
    }


    // 查询的字段
    @Test
    public void test06(){
        // 查询用户的用户名信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        List<User> users = userService.list(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test07(){
        // 查询id小于等于100的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from user where id <=100");
        List<User> list = userService.list(queryWrapper);
        list.forEach(System.out::println);
    }
}
