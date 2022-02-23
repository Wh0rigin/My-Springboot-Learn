package com.who.springboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class SystemConfig {
    @Bean
    public FilterRegistrationBean characterEncodingFilterRegistrationBean(){

        // 创建字符编码器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        // 强制使用指定字符编码
        characterEncodingFilter.setForceEncoding(true);
        // 设置对应编码
        characterEncodingFilter.setEncoding("UTF-8");
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //设置所有过滤
        filterRegistrationBean.setFilter(characterEncodingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
