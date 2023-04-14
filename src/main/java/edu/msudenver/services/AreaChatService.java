package edu.msudenver.services;

import edu.msudenver.models.chats.AreaChat;
import edu.msudenver.models.chats.AreaChatRequest;
import edu.msudenver.models.chats.AreaChatResponse;

import java.util.List;

public interface AreaChatService {
    AreaChat createAreaChat(AreaChatRequest areaChatRequest, Long zoneId);
    List<AreaChat> getAllAreaChats();
    List<AreaChat> getAllAreaChatsByDestinationId(String destinationId);
    List<AreaChat> getAllAreaChatsByFromId(String fromId);
    List<AreaChat> getNewAreaChatsToPlayer(String destinationId);
}