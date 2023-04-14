package edu.msudenver.services;

import edu.msudenver.models.chats.GroupMessages;
import edu.msudenver.models.chats.GroupMessagesRequest;
import java.util.List;

public interface GroupMessagesService {
    GroupMessages createGroupMessages(GroupMessagesRequest groupMessagesRequest);
    List<GroupMessages> getGroupMessagesByGroupId(Long groupId);
    GroupMessages getGroupMessagesById(Long messageId);
    List<GroupMessages> getGroupMessages();
}