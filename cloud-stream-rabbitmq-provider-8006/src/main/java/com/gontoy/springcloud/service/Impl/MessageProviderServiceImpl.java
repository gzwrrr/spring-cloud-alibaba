package com.gontoy.springcloud.service.Impl;

import com.gontoy.springcloud.service.MessageProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author gzw
 * @EnableBinding(Source.class) 定义消息的推送管道
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageProviderServiceImpl implements MessageProviderService {

    /**
     * 消息发送的管道
     */
    @Resource
    private MessageChannel output;


    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("MessageProviderServiceImpl send | serial:" + serial);
        return null;
    }
}
