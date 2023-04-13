package edu.msudenver.models.chats;

import java.util.Date;

public class WorldChatResponse {
    private Long chatId;
    private String chatMessage;
    private String chatType;
    private String fromId;
    private String destinationId;
    private Date chatTime;
    private Long zoneId;

    public WorldChatResponse(WorldChat worldChat) {
        this.chatId = worldChat.getChatId();
        this.chatMessage = worldChat.getChatMessage();
        this.chatType = worldChat.getChatType();
        this.fromId = worldChat.getFromId();
        this.destinationId = worldChat.getDestinationId();
        this.chatTime = worldChat.getChatTime();
        this.zoneId = worldChat.getZoneId();
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
