package com.example.chattickfront;

public class Chat {

    private Long chatId;
    private String chatName;

    public Chat(Long chatId, String chatName) {
        this.chatId = chatId;
        this.chatName = chatName;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
}
