package com.example.chat.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.chat.model.ChatMessage;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Handle incoming messages from clients
    @MessageMapping("/chat")
    public void sendMessage(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/messages", chatMessage);
    }

    // Handle users joining the chat
    @MessageMapping("/join")
    public void userJoined(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/messages", new ChatMessage("Server", chatMessage.getUsername() + " has joined the chat."));
    }

    // Handle users leaving the chat
    @MessageMapping("/leave")
    public void userLeft(ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/messages", new ChatMessage("Server", chatMessage.getUsername() + " has left the chat."));
    }
}
