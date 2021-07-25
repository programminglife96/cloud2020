package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName: com.atguigu.myrule
 * @ClassName: MySelfRule
 * @Description:
 * @Author 李自成 邮箱：lizicheng_public@163.com
 * @Date 2021/7/22 21:20
 * @Version 1.0
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }
}
