package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @PackageName: com.atguigu.springcloud.service
 * @ClassName: PaymentService
 * @Description:
 * @Author 李自成 邮箱：lizicheng_public@163.com
 * @Date 2021/7/24 11:07
 * @Version 1.0
 **/
@Service
public class PaymentService {

    //正常访问
    public String paymentInfo_OK(Integer id) {
        return "线程池 : " + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 : " + Thread.currentThread().getName() + "id:" + id + "\t" + "O(∩_∩)O哈哈~" + "耗时:" ;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return  "线程池：" + Thread.currentThread().getName() + "8001系统繁忙，请稍后再试,id : " + id + "\t" + "o(╥﹏╥)o";
    }
}
