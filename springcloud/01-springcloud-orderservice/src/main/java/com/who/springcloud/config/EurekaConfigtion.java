package com.who.springcloud.config;

//import com.netflix.loadbalancer.BestAvailableRule;
//import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//springcloud loadbalancer
//@LoadBalancerClient(name="USERSERVICE",configuration = CustomLoadBalancerConfiguration.class)
public class EurekaConfigtion {
    @Bean
    @LoadBalanced    //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 选择负载均衡的规则Ribbon
//    @Bean
//    public IRule iRule(){
//        return new BestAvailableRule();
//    }
}
