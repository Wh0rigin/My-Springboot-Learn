package com.who.springboot.service.impl;

import com.who.springboot.mapper.TestMapper;
import com.who.springboot.model.Test;
import com.who.springboot.service.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = TestService.class,version = "1.0.0",timeout = 15000)
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Test queryTestById(Integer id) {
        return testMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer queryAllTestCount() {
        // 首先查询redis内是否有该数据，如果没有到数据库查询并加入到redis
        Integer count = (Integer) redisTemplate.opsForValue().get("allTestCount");
        if(null == count){
            count = testMapper.selectAllTestCount();
            redisTemplate.opsForValue().set("allTestCount",count,30, TimeUnit.SECONDS);     //缓存30秒内的数据
        }
        return count;
    }
}
