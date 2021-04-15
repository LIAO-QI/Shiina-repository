package com.shiina.VO;

public class Message {
    private String Username;
    private String Message;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "Username='" + Username + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}

