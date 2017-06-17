package by.kraskovski.websocket.controller;

import by.kraskovski.websocket.domain.Greeting;
import by.kraskovski.websocket.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("topic/greetings")
    //@Scheduled(fixedDelay = 1000)
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        return new Greeting("Hello, " + message.getName());
    }
}
