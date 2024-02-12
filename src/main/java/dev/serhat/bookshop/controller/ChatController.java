package dev.serhat.bookshop.controller;

import dev.serhat.bookshop.dto.SocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public SocketMessage message(SocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
      //  String time = new SimpleDateFormat("HH:mm").format(new Date());
        return message;
    }
}
