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

        WorldChat savedWorldChat = worldChatService.saveWorldChat(worldChat);
        List<WorldChat> worldChatList = worldChatService.getWorldChatsByZoneId(zoneId);
        List<WorldChatResponse> worldChatResponseList = new ArrayList<>();
        for (WorldChat chat : worldChatList) {
            worldChatResponseList.add(new WorldChatResponse(chat));
        }
        return ResponseEntity.ok(worldChatResponseList);
    }
}