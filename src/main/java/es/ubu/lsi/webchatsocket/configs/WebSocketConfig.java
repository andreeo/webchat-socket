package es.ubu.lsi.webchatsocket.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configuration class for WebSocket messaging
 * This class sets up the WebSocket message broker and STOMP endpoint configuration
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Configures the message broker
     * This method sets the destination prefixes for messages bound for method annotated with @MessageMapping
     * and enables a simple in-memory message broker to carry the messages back to the client on destinations prefixed with "/topic"
     *
     * @param config the MessageBrokerRegistry to configure
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Enable a simple in-memory message broker and configure a prefix for message mappings
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    /**
     * Registers STOMP endpoints
     * This method registers the "/chat-websocket" endpoint, enabling SockJs fallback options so that alternative
     * message options can be used if WebSocket is not available
     *
     * @param registry registry the StompEndPointRegistry to configure
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //register an endpoint for the websocket connection and enable SockJS fallback
        registry.addEndpoint("/chat-websocket").withSockJS();
    }
}
