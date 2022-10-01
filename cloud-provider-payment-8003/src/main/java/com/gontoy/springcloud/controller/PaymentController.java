package com.gontoy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author gzw
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zookeeper")
    public String zookeeper() {
        return String.format("SpringCloud zookeeper | port:%s | id:%s ", serverPort, UUID.randomUUID().toString());
    }
}