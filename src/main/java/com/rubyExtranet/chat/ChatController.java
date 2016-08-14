package com.rubyExtranet.chat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String getMarcoPolo(){
        return "chat";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Chat broadcast(Message message) throws Exception {
        return new Chat(message.getSender() + message.getMessage());
    }
//    @ServerEndpoint("/chatroomServerEndpoint")
//    public static class ChatroomServerEndpoint {
//    	static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());
//    	
//    	/**
//    	 * Called when a connexion is etablished
//    	 * @param userSession
//    	 */
//    	@OnOpen
//    	public void handleOpen(Session userSession){
//    		chatroomUsers.add(userSession);
//    	}
//    	
//    	/**
//    	 * Storing the username when the user sends a message
//    	 * Sending of a confirmation message to the user
//    	 * Sending a message to all connected users
//    	 * @param message
//    	 * @param userSession
//    	 * @throws IOException 
//    	 */
//    	@OnMessage
//    	public void handleMessage(String message, Session userSession) {
//    		String username = (String) userSession.getUserProperties().get("username");
//    		
//    		if(username == null){
//    			userSession.getUserProperties().put("username", message);
//    			try {
//    				userSession.getBasicRemote().sendText(buildJsonMessage("System", "You are connected as " + message));
//    			} catch (Exception e) {
//    				// TODO Auto-generated catch block
////    				e.printStackTrace();
////    				throw new RuntimeException(); 
//    			}
//    		}else{
//    			Iterator<Session> iterator = chatroomUsers.iterator();
//    			while(iterator.hasNext()){
//    				try {
//    					iterator.next().getBasicRemote().sendText(buildJsonMessage(username, message));
//    				} catch (Exception e) {
//    					// TODO Auto-generated catch block
////    					e.printStackTrace();
////    					throw new RuntimeException();
//    				}
//    			}
//    		}
//    	}
//    	/**
//    	 * Fonction that send the confirmation message
//    	 * @param username
//    	 */
//    	private String buildJsonMessage(String username, String message){
//    		JsonObject jsonObject = Json.createObjectBuilder().add("message", username + " : " + message).build();
//    		StringWriter stringWriter = new StringWriter();
//    		try(JsonWriter jsonWriter = Json.createWriter(stringWriter)){
//    			jsonWriter.write(jsonObject);
//    		}
//    		return stringWriter.toString();
//    	}
//    	
//    	/**
//    	 * Called when a connexion has been closed
//    	 * @param userSession
//    	 */
//    	@OnClose
//    	public void handleClose(Session userSession){
//    		chatroomUsers.remove(userSession);
//    	}
//    }
}
