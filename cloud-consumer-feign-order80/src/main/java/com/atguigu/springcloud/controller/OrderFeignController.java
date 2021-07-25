package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.feign.PaymentFeignIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PackageName: com.atguigu.springcloud.controller
 * @ClassName: OrderFeignController
 * @Description:
 * @Author 李自成 邮箱：lizicheng_public@163.com
 * @Date 2021/7/23 22:36
 * @Version 1.0
 **/
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignIService paymentFeignIService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignIService.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignIService.paymentFeignTimeout();
    }
}
