package com.example.web.controllers;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

    @Controller
    public class RabbitController {

//        Logger logger = Logger.getLogger(RabbitController.class);

        @Autowired
        AmqpTemplate template;

        @RequestMapping("/rabbit-send")
        @ResponseBody
        String send() {
//            logger.info("Emit to queue1");
            String rabbit = "Hello everybody";

            template.convertAndSend("Alex", rabbit);
            return "Emit to queue";
        }

        @RequestMapping("/rabbit-recv")
        @ResponseBody
        byte[] recieve() {
//            logger.info("Emit to queue1");
            Message msg = template.receive("Spring");
            Object message = template.receiveAndConvert("Spring");
//            message
            byte [] msg1 = msg.getBody();
            for (byte b : msg1) {
                System.out.println(b);
            }
//            System.out.println(msg.getBody().);
            return msg.getBody();
        }
    }
