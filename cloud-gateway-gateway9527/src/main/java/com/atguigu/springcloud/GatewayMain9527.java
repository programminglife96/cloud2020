package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @PackageName: com.atguigu.springcloud
 * @ClassName: GatewayMain9527
 * @Description:
 * @Author 李自成 邮箱：lizicheng_public@163.com
 * @Date 2021/7/24 22:35
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class,args);
    }
}
