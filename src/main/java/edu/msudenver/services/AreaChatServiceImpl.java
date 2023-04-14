package edu.msudenver.services;

import edu.msudenver.models.chats.AreaChat;
import edu.msudenver.models.chats.AreaChatRequest;
import edu.msudenver.repository.AreaChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AreaChatServiceImpl implements AreaChatService {

    @Autowired
    private AreaChatRepository areaChatRepository;

    @Override
    public AreaChat createAreaChat(AreaChatRequest areaChatRequest, Long zoneId) {
        AreaChat areaChat = new AreaChat();
        areaChat.setChatMessage(areaChatRequest.getChatMessage());
        areaChat.setChatType(areaChatRequest.getChatType());
        areaChat.setFromId(areaChatRequest.getFromId());
        areaChat.setDestinationId(areaChatRequest.getDestinationId());
        areaChat.setChatTime(new Date());
        areaChat.setZoneId(zoneId);
        return areaChatRepository.save(areaChat);
    }

    @Override
    public List<AreaChat> getAllAreaChats() {
        return areaChatRepository.findAll();
    }

    @Override
    public List<AreaChat> getAllAreaChatsByDestinationId(String destinationId) {
        return areaChatRepository.findByDestinationIdOrderByChatTimeAsc(destinationId);
    }

    @Override
    public List<AreaChat> getAllAreaChatsByFromId(String fromId) {
        return areaChatRepository.findByFromId(fromId);
    }

    @Override
    public List<AreaChat> getNewAreaChatsToPlayer(String destinationId) {
        return areaChatRepository.findByDestinationIdAndChatTimeGreaterThan(destinationId, new Date(System.currentTimeMillis() - 30000));
    }

}
