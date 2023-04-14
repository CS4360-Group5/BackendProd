package edu.msudenver.models.chats;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "group_members")
public class GroupMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_members_id")
    private Long groupMembersId;

    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "joined_time")
    private Date joinedTime;

    @Column(name = "left_time")
    private Date leftTime;

    @Column(name = "player_id")
    private String playerId;

    public GroupMembers() {}

    public GroupMembers(Long groupId, Date joinedTime, Date leftTime, String playerId) {
        this.groupId = groupId;
        this.joinedTime = joinedTime;
        this.leftTime = leftTime;
        this.playerId = playerId;
    }

    public Long getGroupMembersId() {
        return groupMembersId;
    }

    public void setGroupMembersId(Long groupMembersId) {
        this.groupMembersId = groupMembersId;
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
