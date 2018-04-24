/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jeather.WebSocket.resource;

import com.jeather.WebSocket.model.Greeting;
import com.jeather.WebSocket.model.HelloMessages;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 *
 * @author WorkNest8
 */
@Controller
public class GreetingResource {
    
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting getGreeting(HelloMessages helloMessages)throws Exception{
        Thread.sleep(1000);//Simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessages.getName()) + "!");
    }
    
}
