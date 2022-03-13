package com.who.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.who.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper extends BaseMapper<User> {
}
