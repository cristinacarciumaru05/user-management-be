package com.user.demo;

import org.springframework.stereotype.Service;

@Service
public class MessageHandler {

    private String message;
    private String level;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
