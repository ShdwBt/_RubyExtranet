package com.ruby.domain;

import lombok.Getter;

@Getter
public class Message {
    private String sender;
    private String message;

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}
