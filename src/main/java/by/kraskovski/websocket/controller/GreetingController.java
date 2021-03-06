package by.kraskovski.websocket.controller;

import by.kraskovski.websocket.domain.Greeting;
import by.kraskovski.websocket.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    @MessageMapping("/websocket-example") //end-point mapping listener
    @SendTo("topic/greetings") //sending response from this url
    public Greeting greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000);
        return new Greeting("Hello, " + message.getName());
    }
}
