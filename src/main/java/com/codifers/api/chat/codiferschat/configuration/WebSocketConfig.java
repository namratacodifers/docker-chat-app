package com.codifers.api.chat.codiferschat.configuration;
  
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
  
@Configuration
@EnableWebSocketMessageBroker 
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  
	@Override 
	public void registerStompEndpoints(StompEndpointRegistry registry){ 
		  // TODO Auto-generated method stub
		  registry.addEndpoint("/chatCodifers").setAllowedOrigins("*").withSockJS(); 
	}
	  
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry){ 
		// TODO Auto-generated method stub
		registry.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/topic","/queue"); 
		
	}
  
}
 