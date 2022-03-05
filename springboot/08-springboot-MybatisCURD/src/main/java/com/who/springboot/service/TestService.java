package com.who.springboot.service;

import com.who.springboot.model.Test;

public interface TestService {
    /**
     * 根据TestId查询Test信息
     * @param id
     * @return
     */
    Test queryTestById(Integer id);

    boolean deleteTestById(Integer id);

    boolean updateTestById(Integer id, String name, String pwd);

    boolean insertTestById(String name, String pwd);
}
