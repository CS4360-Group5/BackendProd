package edu.msudenver.controllers.chats;

import edu.msudenver.models.chats.GroupChat;
import edu.msudenver.models.chats.GroupChatRequest;
import edu.msudenver.models.chats.GroupChatResponse;
import edu.msudenver.services.GroupChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chats/groups")
public class GroupChatController {
    @Autowired
    private GroupChatService groupChatService;

    @GetMapping
    public ResponseEntity<List<GroupChatResponse>> getGroupChats() {
        List<GroupChat> groupChats = groupChatService.getGroupChats();
        List<GroupChatResponse> groupChatResponses = new ArrayList<>();
        for (GroupChat groupChat : groupChats) {
            GroupChatResponse groupChatResponse = new GroupChatResponse(groupChat.getGroupChatId(), groupChat.getGroupId(), groupChat.getGroupName());
            groupChatResponses.add(groupChatResponse);
        }
        return ResponseEntity.ok(groupChatResponses);
    }

    @PostMapping
    public ResponseEntity<GroupChatResponse> createGroupChat(@RequestBody List<GroupChatRequest> groupChatRequests) {
        GroupChatRequest request = groupChatRequests.get(0);
        GroupChat savedGroupChat = groupChatService.createGroupChat(request);
        GroupChatResponse groupChatResponse = new GroupChatResponse(savedGroupChat.getGroupChatId(), savedGroupChat.getGroupId(), savedGroupChat.getGroupName());
        return ResponseEntity.ok(groupChatResponse);
    }

    @PostMapping("/external/createone")
    public ResponseEntity<GroupChatResponse> createGroupChatExternal(@RequestBody GroupChatRequest groupChatRequest) {
        GroupChat savedGroupChat = groupChatService.createGroupChat(groupChatRequest);
        GroupChatResponse groupChatResponse = new GroupChatResponse(savedGroupChat.getGroupChatId(), savedGroupChat.getGroupId(), savedGroupChat.getGroupName());
        return ResponseEntity.ok(groupChatResponse);
    }

    @GetMapping("/external/getall")
    public ResponseEntity<List<GroupChatResponse>> getGroupChatsExternal() {
        List<GroupChat> groupChats = groupChatService.getGroupChats();
        List<GroupChatResponse> groupChatResponses = new ArrayList<>();
        for (GroupChat groupChat : groupChats) {
            GroupChatResponse groupChatResponse = new GroupChatResponse(groupChat.getGroupChatId(), groupChat.getGroupId(), groupChat.getGroupName());
            groupChatResponses.add(groupChatResponse);
        }
        return ResponseEntity.ok(groupChatResponses);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupChatResponse> getGroupChat(@PathVariable Long groupId) {
        GroupChat groupChat = groupChatService.getGroupChatById(groupId);

        if (groupChat == null) {
            return ResponseEntity.notFound().build();
        }

        GroupChatResponse groupChatResponse = new GroupChatResponse(groupChat.getGroupChatId(), groupChat.getGroupId(), groupChat.getGroupName());
        return ResponseEntity.ok(groupChatResponse);
    }
}
