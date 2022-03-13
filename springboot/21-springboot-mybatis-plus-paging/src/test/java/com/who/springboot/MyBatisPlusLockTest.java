package com.who.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.who.springboot.pojo.Product;
import com.who.springboot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusLockTest {

    @Autowired
    private ProductService productService;


    // 乐观锁 在数据中加入版本信息,以免重复写入
    // 要实现乐观锁需要在orm中vesion字段上加入version注释
    @Test
    public void testProduct01(){
        // A查询产品信息
        QueryWrapper<Product> queryWrapperA = new QueryWrapper<>();
        queryWrapperA.eq("id",1);
        Product productA = productService.getOne(queryWrapperA);
        System.out.println(productA);
        // B查询产品信息
        QueryWrapper<Product> queryWrapperB = new QueryWrapper<>();
        queryWrapperB.eq("id",1);
        Product productB = productService.getOne(queryWrapperB);
        System.out.println(productB);
        // A将价格+50
        productA.setPrice(productA.getPrice()+50);
        productService.updateById(productA);
        // B将产品价格-30
        productB.setPrice(productB.getPrice()-30);
        boolean res = productService.updateById(productB);
        // 若查询失败, 重新取得商品信息并修改
        while(!res){
            productB = productService.getOne(queryWrapperB);
            productB.setPrice(productB.getPrice()-30);
            res = productService.updateById(productB);
        }

        // C查询产品
        QueryWrapper<Product> queryWrapperC = new QueryWrapper<>();
        queryWrapperC.eq("id",1);
        Product productC = productService.getOne(queryWrapperB);
        System.out.println(productC);
    }
}
