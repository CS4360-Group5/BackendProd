package edu.msudenver.controllers.chats;

import edu.msudenver.models.chats.WorldChat;
import edu.msudenver.models.chats.WorldChatRequest;
import edu.msudenver.models.chats.WorldChatResponse;
import edu.msudenver.services.WorldChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chats/world")
public class WorldChatController {

    @Autowired
    private WorldChatService worldChatService;

    @GetMapping
    public ResponseEntity<List<WorldChatResponse>> getAllChatsByTypeWorld() {
        List<WorldChat> worldChatList = worldChatService.getAllWorldChats();
        List<WorldChatResponse> worldChatResponseList = new ArrayList<>();
        for (WorldChat chat : worldChatList) {
            worldChatResponseList.add(new WorldChatResponse(chat));
        }
        return ResponseEntity.ok(worldChatResponseList);
    }

    @PostMapping("/{zoneId}")
    public ResponseEntity<List<WorldChatResponse>> createWorldChat(@PathVariable Long zoneId, @RequestBody WorldChatRequest worldChatRequest) {
        WorldChat worldChat = new WorldChat(worldChatRequest.getChatMessage(),
                Date.from(worldChatRequest.getChatTime().toInstant()),
                worldChatRequest.getChatType(),
                worldChatRequest.getDestinationId(),
                worldChatRequest.getFromId(),
                zoneId);

        WorldChat savedWorldChat = worldChatService.createWorldChat(worldChat);
        List<WorldChat> worldChatList = worldChatService.getWorldChatsByZoneId(zoneId);
        List<WorldChatResponse> worldChatResponseList = new ArrayList<>();
        for (WorldChat chat : worldChatList) {
            worldChatResponseList.add(new WorldChatResponse(chat));
        }
        return ResponseEntity.ok(worldChatResponseList);
    }

    @GetMapping("/all/{destinationId}")
    public ResponseEntity<List<WorldChatResponse>> getAllWorldChats(@PathVariable String destinationId) {
        List<WorldChat> worldChatList = worldChatService.getAllWorldChats();
        List<WorldChatResponse> worldChatResponseList = new ArrayList<>();

        for (WorldChat worldChat : worldChatList) {
            if (worldChat.getDestinationId().equals(destinationId)) {
                worldChatResponseList.add(new WorldChatResponse(worldChat));
            }
        }

        return ResponseEntity.ok(worldChatResponseList);
    }

    @GetMapping("/from/{fromId}")
    public ResponseEntity<List<WorldChatResponse>> getWorldChatsByFromId(@PathVariable String fromId) {
        List<WorldChat> worldChatList = worldChatService.getWorldChatsByFromId(fromId);
        List<WorldChatResponse> worldChatResponseList = new ArrayList<>();

        for (WorldChat worldChat : worldChatList) {
            WorldChatResponse worldChatResponse = new WorldChatResponse(worldChat);
            worldChatResponseList.add(worldChatResponse);
        }

        return ResponseEntity.ok(worldChatResponseList);
    }

    @GetMapping("/{destinationId}")
    public List<WorldChatResponse> getNewWorldChatsToPlayer(@PathVariable String destinationId) {
        List<WorldChat> worldChats = worldChatService.getNewWorldChatsToPlayer(destinationId);
        List<WorldChatResponse> worldChatResponses = new ArrayList<>();
        for (WorldChat worldChat : worldChats) {
            worldChatResponses.add(new WorldChatResponse(worldChat));
        }
        return worldChatResponses;
    }
}