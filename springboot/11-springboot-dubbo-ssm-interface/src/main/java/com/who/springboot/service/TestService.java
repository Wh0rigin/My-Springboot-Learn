package com.who.springboot.service;

import com.who.springboot.model.Test;

public interface TestService {
    Test queryTestById(Integer id);

    Integer queryAllTestCount();
}
