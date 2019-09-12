package com.example.chattickfront;

import java.util.Date;

public class Message {

    private Long messageId;
    private String text;
    private String createdWhen;
    private Long createdBy;
    private Boolean isRead;
    private Long chatId;

    public Message(Long messageId, String text, String createdWhen, Long createdBy, Boolean isRead, Long chatId) {
        this.messageId = messageId;
        this.text = text;
        this.createdWhen = createdWhen;
        this.createdBy = createdBy;
        this.isRead = isRead;
        this.chatId = chatId;
    }

    public Boolean isRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String  getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(String createdWhen) {
        this.createdWhen = createdWhen;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isAuthorizedUserMessage() {
        return AuthoriziedUser.getAuthoriziedUser().getId().equals(createdBy);
    }
}
