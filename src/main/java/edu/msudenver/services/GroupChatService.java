package edu.msudenver.services;

import edu.msudenver.models.chats.GroupChat;
import edu.msudenver.models.chats.GroupChatRequest;

import java.util.List;

public interface GroupChatService {
    GroupChat createGroupChat(GroupChatRequest groupChatRequest);
    List<GroupChat> getGroupChats();
    GroupChat getGroupChatById(Long groupId);
}