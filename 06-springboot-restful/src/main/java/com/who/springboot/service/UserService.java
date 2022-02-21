package com.who.springboot.service;

import com.who.springboot.resources.User;

public interface UserService {
    // do select
    public User selectUserById(Integer id);
    public User selectUserByName(String name);

    public Integer selectUserByName(String name,String pwd);

    // do delete
    public boolean deleteUserById(Integer id);
    public boolean deleteUserByName(String name);

    // do Insert
    public boolean insertUser(String Name,String pwd);
}
