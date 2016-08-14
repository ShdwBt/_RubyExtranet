package com.rubyExtranet.chat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/hello").withSockJS();
	}
	
//	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
//	
//	@OnOpen
//	public void handleOpen(Session userSession){
//		chatroomUsers.add(userSession);
//	}

}