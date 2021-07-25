package com.atguigu.springcloud;

import com.sun.deploy.net.proxy.ProxyUnavailableException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName: com.atguigu.springcloud
 * @ClassName: OrderHystrixMain80
 * @Description:
 * @Author 李自成 邮箱：lizicheng_public@163.com
 * @Date 2021/7/24 13:10
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
