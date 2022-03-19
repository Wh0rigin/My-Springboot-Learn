package com.who.springcloud.fallback;

import com.who.springcloud.clients.UserClient;
import com.who.springcloud.model.User;
import feign.hystrix.FallbackFactory;

public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient(){

            @Override
            public User findUserById(Integer id) {
                System.err.println("查询用户失败");
                return new User();
            }
        };
    }
}
