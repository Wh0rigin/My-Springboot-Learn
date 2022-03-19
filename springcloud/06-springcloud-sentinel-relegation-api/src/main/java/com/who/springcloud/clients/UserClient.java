package com.who.springcloud.clients;


import com.who.springcloud.fallback.UserClientFallbackFactory;
import com.who.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "userservice" , fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {
    @GetMapping("/user/detail/{id}")
    User findUserById(@PathVariable Integer id);
}
