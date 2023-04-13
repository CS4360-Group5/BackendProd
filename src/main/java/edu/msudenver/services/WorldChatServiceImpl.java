package edu.msudenver.services;

import edu.msudenver.models.chats.WorldChat;
import edu.msudenver.repository.WorldChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldChatServiceImpl implements WorldChatService {

    @Autowired
    private WorldChatRepository worldChatRepository;

    @Override
    public WorldChat createWorldChat(WorldChat worldChat) {
        return worldChatRepository.save(worldChat);
    }

    @Override
    public List<WorldChat> getWorldChatsByZoneId(Long zoneId) {
        return worldChatRepository.findByZoneId(zoneId);
    }

    @Override
    public WorldChat saveWorldChat(WorldChat worldChat) {
        return worldChatRepository.save(worldChat);
    }
    @Override
    public List<WorldChat> getAllWorldChats() {
        return worldChatRepository.findAll();
    }
}