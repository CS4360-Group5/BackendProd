package edu.msudenver.models.chats;

import java.util.Date;

public class GroupMessagesRequest {
    private Long messageId;
    private Long groupId;
    private Date sentTime;
    private String fromPlayerId;
    private String content;

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

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public String getFromPlayerId() {
        return fromPlayerId;
    }

    public void setFromPlayerId(String fromPlayerId) {
        this.fromPlayerId = fromPlayerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
