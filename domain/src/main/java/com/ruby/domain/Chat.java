package com.ruby.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Chat {
    private String content;

    public Chat(String content) {
        this.content = content;
    }
}
