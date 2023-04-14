package edu.msudenver.services;

import edu.msudenver.models.chats.GroupChat;
import edu.msudenver.models.chats.GroupChatRequest;
import edu.msudenver.repository.GroupChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupChatServiceImpl implements GroupChatService {
    @Autowired
    private GroupChatRepository groupChatRepository;

    @Override
    public GroupChat createGroupChat(GroupChatRequest groupChatRequest) {
        GroupChat groupChat = new GroupChat();
        groupChat.setGroupId(groupChatRequest.getGroupId());
        groupChat.setGroupName(groupChatRequest.getGroupName());
        groupChatRepository.save(groupChat);
        return groupChat;
    }

    @Override
    public List<GroupChat> getGroupChats() {
        return groupChatRepository.findAll();
    }
    @Override
    public GroupChat getGroupChatById(Long groupId) {
        return groupChatRepository.findById(groupId).orElse(null);
    }
}
