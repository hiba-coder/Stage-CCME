package com.example.mysql_connection.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController implements ActiveUserChangeListener {


    @Autowired
    private auto simpMessagingTemplate;

    @MessageMapping("/chat/{userDestination}")
    public void sendMessage(@DestinationVariable String userDestination, Message message){
        simpMessagingTemplate.convertAndSend("/topic/messages"+userDestination,message);
        /*simpMessagingTemplate.convertAndSendToUser();*/
    }

    @Override
    public void notifyActiveUserChange() {

    }
}
