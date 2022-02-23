package com.who.springboot.config;

import com.who.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration  //定义此类为配置类
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] addPath = {
                "/user/**"
        };
        String[] excludePath = {
                "/user/login",
                "/user/error",
                "/user/public"
        };
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPath).excludePathPatterns(excludePath);
    }
}
