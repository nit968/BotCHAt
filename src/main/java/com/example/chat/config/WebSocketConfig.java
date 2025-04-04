package com.example.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register WebSocket endpoint for clients to connect
        registry.addEndpoint("/chat")  // /chat is the WebSocket endpoint
                .setAllowedOrigins("https://botchat-nnbv.onrender.com")  // Allow only this origin to connect
                .withSockJS();  // Enable SockJS fallback options if WebSocket is not supported
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Set up a message broker for broadcasting messages to clients
        config.enableSimpleBroker("/topic");  // Prefix for topics to which clients can subscribe
        config.setApplicationDestinationPrefixes("/app");  // Prefix for messages sent from clients
    }


}


