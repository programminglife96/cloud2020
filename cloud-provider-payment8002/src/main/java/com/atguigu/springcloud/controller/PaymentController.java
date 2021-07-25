package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import sun.management.snmp.jvmmib.EnumJvmClassesVerboseLevel;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName: com.atguigu.springcloud.controller
 * @ClassName: PaymentController
 * @Description:
 * @Author 李自成 邮箱：lizicheng_public@163.com
 * @Date 2021/7/21 22:49
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****查询结果：" + result + "O(∩_∩)O哈哈~");

        if(result > 0) {
            return new CommonResult(200,"插入数据库成功！,serverPort" + serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入結果：" + payment);

        if(payment != null) {
            return new CommonResult(200,"查询成功！,serverPort" + serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录！查询ID：" + id,null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
