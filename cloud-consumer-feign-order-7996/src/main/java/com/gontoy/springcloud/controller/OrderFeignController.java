package com.gontoy.springcloud.controller;

import com.gontoy.springcloud.entities.CommonResult;
import com.gontoy.springcloud.entities.Payment;
import com.gontoy.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gzw
 */
@Slf4j
@RestController
@RequestMapping("/consumer/payment")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")  Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
