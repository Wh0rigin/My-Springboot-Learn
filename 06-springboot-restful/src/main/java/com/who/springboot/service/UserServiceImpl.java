package com.who.springboot.service;

import com.who.springboot.resources.User;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Override
    public User selectUserById(Integer id) {
        // TODO CURD
        return null;
    }


    @Override
    public User selectUserByName(String name) {
        // TODO CURD
        return null;
    }


    @Override
    public Integer selectUserByName(String name, String pwd) {
        // TODO CURD
        return null;
    }


    @Override
    public boolean deleteUserById(Integer id) {
        // TODO CURD
        return false;
    }


    @Override
    public boolean deleteUserByName(String name) {
        // TODO CURD
        return false;
    }

    @Override
    public boolean insertUser(String Name, String pwd) {
        // TODO CURD
        return false;
    }
}
