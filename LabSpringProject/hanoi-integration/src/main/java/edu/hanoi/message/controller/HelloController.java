package edu.hanoi.message.controller;

import edu.hanoi.message.service.HelloService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.store.ChannelMessageStore;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {
    @Autowired
    private DirectChannel helloChannel;

    @RequestMapping(value = "/say")
    public boolean say(@RequestParam String name){
        return helloChannel.send(MessageBuilder.withPayload(name).build());
    }

}
