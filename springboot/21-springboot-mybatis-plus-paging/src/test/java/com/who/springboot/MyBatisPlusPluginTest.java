package com.who.springboot;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.who.springboot.pojo.User;
import com.who.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusPluginTest {
    @Autowired
    private UserService userService;

    private List<User> pages;
    private Page<User> page;
    // 带分页的查询
    @Test
    public void page(){
        page = new Page<>(1,2);
        userService.page(page);
        System.out.println(page);

        // 翻页查询
        for(int i = 1;i <= page.getPages();i++){
            page.setCurrent(i);
            userService.page(page);
            System.out.println(page);

            pages = page.getRecords();
            pages.forEach(System.out::println);

            System.out.println("getCurrent():"+page.getCurrent());
            System.out.println("getPages():"+page.getPages());
            System.out.println("getTotal():"+page.getTotal());
            System.out.println("hasNext():"+page.hasNext());
            System.out.println("hasPrevious():"+page.hasPrevious());
        }



    }
}
