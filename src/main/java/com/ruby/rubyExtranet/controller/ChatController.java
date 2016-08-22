package com.ruby.rubyExtranet.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ruby.rubyExtranet.model.chat.Chat;
import com.ruby.rubyExtranet.model.chat.Message;

@Controller
public class ChatController {

    @RequestMapping(value = "/chatPage", method = RequestMethod.GET)
    public ModelAndView getChatPage(ModelAndView model){
    	model.setViewName("chatPage");
        return model;
    }

    @MessageMapping("/chatPage")
    @SendTo("/chat/broadcast")
    public Chat broadcast(Message message) throws Exception {
        return new Chat(message.getSender() + message.getMessage());
    }

}
