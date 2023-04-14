package edu.msudenver.controllers.chats;

import edu.msudenver.models.chats.AreaChat;
import edu.msudenver.models.chats.AreaChatRequest;
import edu.msudenver.models.chats.AreaChatResponse;
import edu.msudenver.services.AreaChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chats/area")
public class AreaChatController {

    @Autowired
    AreaChatService areaChatService;

    @GetMapping("/chats/area")
    public List<AreaChatResponse> getAllChatsByTypeArea() {
        List<AreaChat> areaChats = areaChatService.getAllAreaChats();
        List<AreaChatResponse> areaChatResponses = new ArrayList<>();
        for (AreaChat areaChat : areaChats) {
            AreaChatResponse areaChatResponse = new AreaChatResponse(areaChat);
            areaChatResponses.add(areaChatResponse);
        }
        return areaChatResponses;
    }

    @GetMapping("/all/{destinationId}")
    public List<AreaChatResponse> getAllAreaChatsToPlayer(@PathVariable String destinationId) {
        List<AreaChat> areaChats = areaChatService.getAllAreaChatsByDestinationId(destinationId);
        List<AreaChatResponse> responses = new ArrayList<>();
        for (AreaChat areaChat : areaChats) {
            responses.add(new AreaChatResponse(areaChat));
        }
        return responses;
    }

    @GetMapping("/from/{fromId}")
    public List<AreaChatResponse> getAllAreaChatsFromPlayer(@PathVariable String fromId) {
        List<AreaChat> areaChats = areaChatService.getAllAreaChatsByFromId(fromId);
        List<AreaChatResponse> areaChatResponses = new ArrayList<>();
        for (AreaChat areaChat : areaChats) {
            AreaChatResponse areaChatResponse = new AreaChatResponse(areaChat);
            areaChatResponses.add(areaChatResponse);
        }
        return areaChatResponses;
    }

    @GetMapping("/{destinationId}")
    public ResponseEntity<List<AreaChatResponse>> getNewAreaChatsToPlayer(@PathVariable String destinationId) {
        List<AreaChat> areaChats = areaChatService.getNewAreaChatsToPlayer(destinationId);
        List<AreaChatResponse> areaChatResponses = new ArrayList<>();
        for (AreaChat areaChat : areaChats) {
            areaChatResponses.add(new AreaChatResponse(areaChat));
        }
        return ResponseEntity.ok(areaChatResponses);
    }

    @PostMapping("/{zoneId}")
    public ResponseEntity<List<AreaChatResponse>> createAreaChat(@RequestBody AreaChatRequest areaChatRequest, @PathVariable Long zoneId) {
        AreaChat areaChat = areaChatService.createAreaChat(areaChatRequest, zoneId);
        List<AreaChatResponse> areaChatResponses = new ArrayList<>();
        areaChatResponses.add(new AreaChatResponse(areaChat));
        return ResponseEntity.ok(areaChatResponses);
    }
}
