package com.example.mysql_connection.Chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class auto extends SimpMessagingTemplate {



    public auto(@Qualifier("brokerChannel") MessageChannel messageChannel) {
        super(messageChannel);
    }
}
