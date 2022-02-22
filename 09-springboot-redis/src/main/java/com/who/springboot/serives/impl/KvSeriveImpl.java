package com.who.springboot.serives.impl;

import com.who.springboot.serives.KvSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class KvSeriveImpl implements KvSerive {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    @Override
    public void putKv(String key, String value) {
        redisTemplate.opsForValue().set(key,value);

    }

    @Override
    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
