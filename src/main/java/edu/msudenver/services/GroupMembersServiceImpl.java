package edu.msudenver.services;

import edu.msudenver.models.chats.GroupMembers;
import edu.msudenver.models.chats.GroupMembersRequest;
import edu.msudenver.repository.GroupMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMembersServiceImpl implements GroupMembersService {
    @Autowired
    private GroupMembersRepository groupMembersRepository;

    @Override
    public GroupMembers createGroupMembers(GroupMembersRequest groupMembersRequest) {
        GroupMembers groupMembers = new GroupMembers();
        groupMembers.setGroupId(groupMembersRequest.getGroupId());
        groupMembers.setJoinedTime(groupMembersRequest.getJoinedTime());
        groupMembers.setLeftTime(groupMembersRequest.getLeftTime());
        groupMembers.setPlayerId(groupMembersRequest.getPlayerId());
        groupMembersRepository.save(groupMembers);
        return groupMembers;
    }

    @Override
    public List<GroupMembers> getGroupMembersByGroupId(Long groupId) {
        return groupMembersRepository.findByGroupId(groupId);
    }

    @Override
    public List<GroupMembers> getGroupMembers() {
        return groupMembersRepository.findAll();
    }
}
