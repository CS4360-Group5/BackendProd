package edu.msudenver.models.chats;

import java.util.Date;

public class GroupMembersResponse {
    private Long groupId;
    private Date joinedTime;
    private Date leftTime;
    private String playerId;

    public GroupMembersResponse(GroupMembers groupMembers) {
        this.groupId = groupMembers.getGroupId();
        this.joinedTime = groupMembers.getJoinedTime();
        this.leftTime = groupMembers.getLeftTime();
        this.playerId = groupMembers.getPlayerId();
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Date getJoinedTime() {
        return joinedTime;
    }

    public void setJoinedTime(Date joinedTime) {
        this.joinedTime = joinedTime;
    }

    public Date getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(Date leftTime) {
        this.leftTime = leftTime;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
