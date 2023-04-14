package edu.msudenver.models.chats;


import java.util.Date;

public class GroupMessagesResponse {
    private Long messageId;
    private Long groupId;
    private String content;
    private String fromPlayerId;
    private Date sentTime;

    public GroupMessagesResponse(GroupMessages groupMessages) {
        this.messageId = groupMessages.getMessageId();
        this.groupId = groupMessages.getGroupId();
        this.content = groupMessages.getContent();
        this.fromPlayerId = groupMessages.getFromPlayerId();
        this.sentTime = groupMessages.getSentTime();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromPlayerId() {
        return fromPlayerId;
    }

    public void setFromPlayerId(String fromPlayerId) {
        this.fromPlayerId = fromPlayerId;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }
}