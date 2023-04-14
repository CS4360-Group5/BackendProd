package edu.msudenver.models.chats;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "group_messages")
public class GroupMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "sent_time")
    private Date sentTime;

    @Column(name = "from_player_id")
    private String fromPlayerId;

    @Column(name = "content")
    private String content;

    public GroupMessages() {}

    public GroupMessages(Long groupId, Date sentTime, String fromPlayerId, String content) {
        this.groupId = groupId;
        this.sentTime = sentTime;
        this.fromPlayerId = fromPlayerId;
        this.content = content;
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