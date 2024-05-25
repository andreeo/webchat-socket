package es.ubu.lsi.webchatsocket.controllers;

import es.ubu.lsi.webchatsocket.utils.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Chat controller to handle incoming and outgoing messages.
 */
@Controller
public class ChatController {

    /**
     * Handles incoming messages sent to "/chat.sendMessage" and forwards them to "/topic/public".
     *
     * @param message The received message.
     * @return The message to be sent to all subscribers of "/topic/public".
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(Message message) {
        return message;
    }
}
