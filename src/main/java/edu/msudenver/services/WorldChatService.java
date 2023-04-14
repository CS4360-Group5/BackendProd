package edu.msudenver.services;

import edu.msudenver.models.chats.WorldChat;

import java.util.List;

public interface WorldChatService {
    WorldChat createWorldChat(WorldChat worldChat);
    List<WorldChat> getWorldChatsByZoneId(Long zoneId);
    List<WorldChat> getAllWorldChats();
    List<WorldChat> getWorldChatsByFromId(String fromId);
    List<WorldChat> getNewWorldChatsToPlayer(String destinationId);
}