package com.who.springboot.service.impl;

import com.who.springboot.mapper.TestMapper;
import com.who.springboot.model.Test;
import com.who.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public Test queryTestById(Integer id) {
        return testMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteTestById(Integer id) {
        Integer res = testMapper.deleteByPrimaryKey(id);
        return res==1?true:false;
    }

    @Override
    public boolean updateTestById(Integer id, String name, String pwd) {
        Test test = new Test();
        test.setId(id);
        test.setName(name);
        test.setPassword(pwd);
        Integer res = testMapper.updateByPrimaryKey(test);
        return res > 0?true:false;
    }

    @Override
    public boolean insertTestById(String name, String pwd) {
        Test test = new Test();
        test.setName(name);
        test.setPassword(pwd);
        Integer res = testMapper.insert(test);
        return res > 0?true:false;
    }
}
