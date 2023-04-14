package edu.msudenver.services;

import edu.msudenver.models.chats.GroupMessages;
import edu.msudenver.models.chats.GroupMessagesRequest;
import edu.msudenver.repository.GroupMessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMessagesServiceImpl implements GroupMessagesService {
    @Autowired
    private GroupMessagesRepository groupMessagesRepository;

    @Override
    public GroupMessages createGroupMessages(GroupMessagesRequest groupMessagesRequest) {
        GroupMessages groupMessages = new GroupMessages();
        groupMessages.setContent(groupMessagesRequest.getContent());
        groupMessages.setFromPlayerId(groupMessagesRequest.getFromPlayerId());
        groupMessages.setGroupId(groupMessagesRequest.getGroupId());
        groupMessages.setSentTime(groupMessagesRequest.getSentTime());
        groupMessagesRepository.save(groupMessages);
        return groupMessages;
    }

    @Override
    public List<GroupMessages> getGroupMessagesByGroupId(Long groupId) {
        return groupMessagesRepository.findAllByGroupId(groupId);
    }

    @Override
    public GroupMessages getGroupMessagesById(Long messageId) {
        return groupMessagesRepository.findById(messageId).orElse(null);
    }

    @Override
    public List<GroupMessages> getGroupMessages() {
        return groupMessagesRepository.findAll();
    }
}