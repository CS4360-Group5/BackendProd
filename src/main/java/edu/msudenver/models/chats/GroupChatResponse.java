package edu.msudenver.models.chats;

public class GroupChatResponse {
    private Long groupChatId;
    private Long groupId;
    private String groupName;

    public GroupChatResponse(Long groupChatId, Long groupId, String groupName) {
        this.groupChatId = groupChatId;
        this.groupId = groupId;
        this.groupName = groupName;
    }

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
