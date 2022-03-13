package com.who.springboot.mybatis.service.impl;

import com.who.springboot.mybatis.entity.User;
import com.who.springboot.mybatis.mapper.UserMapper;
import com.who.springboot.mybatis.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author who
 * @since 2022-03-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
