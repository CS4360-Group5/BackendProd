package edu.msudenver.models.chats;

import javax.persistence.*;

@Entity
@Table(name = "group_chat")
public class GroupChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_chat_id")
    private Long groupChatId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;


    public Long getGroupChatId() {
        return groupChatId;
    }

    public void setGroupChatId(Long groupChatId) {
        this.groupChatId = groupChatId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}