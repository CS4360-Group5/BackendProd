package edu.msudenver.services;

import edu.msudenver.models.chats.GroupMembers;
import edu.msudenver.models.chats.GroupMembersRequest;

import java.util.List;

public interface GroupMembersService {
    GroupMembers createGroupMembers(GroupMembersRequest groupMembersRequest);

    List<GroupMembers> getGroupMembersByGroupId(Long groupId);

    List<GroupMembers> getGroupMembers();
}