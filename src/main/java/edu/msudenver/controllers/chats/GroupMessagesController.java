package edu.msudenver.controllers.chats;

import edu.msudenver.models.chats.GroupMessages;
import edu.msudenver.models.chats.GroupMessagesRequest;
import edu.msudenver.models.chats.GroupMessagesResponse;
import edu.msudenver.services.GroupMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chats/messages")
public class GroupMessagesController {

    @Autowired
    private GroupMessagesService groupMessagesService;

    @GetMapping("/{messageId}")
    public ResponseEntity<GroupMessagesResponse> getGroupMessages(@PathVariable Long messageId) {
        GroupMessages groupMessages = groupMessagesService.getGroupMessagesById(messageId);
        GroupMessagesResponse groupMessagesResponse = new GroupMessagesResponse(groupMessages);
        return ResponseEntity.ok(groupMessagesResponse);
    }

    @PostMapping
    public ResponseEntity<GroupMessagesResponse> createGroupMessages(@RequestBody GroupMessagesRequest groupMessagesRequest) {
        GroupMessages savedGroupMessages = groupMessagesService.createGroupMessages(groupMessagesRequest);
        GroupMessagesResponse groupMessagesResponse = new GroupMessagesResponse(savedGroupMessages);
        return ResponseEntity.ok(groupMessagesResponse);
    }

    @PostMapping("/external/createone")
    public ResponseEntity<GroupMessagesResponse> createGroupMessagesExternal(@RequestBody GroupMessagesRequest groupMessagesRequest) {
        GroupMessages savedGroupMessages = groupMessagesService.createGroupMessages(groupMessagesRequest);
        GroupMessagesResponse groupMessagesResponse = new GroupMessagesResponse(savedGroupMessages);
        return ResponseEntity.ok(groupMessagesResponse);
    }

    @GetMapping("/external/getall")
    public ResponseEntity<List<GroupMessagesResponse>> getGroupMessagesExternal() {
        List<GroupMessages> groupMessagesList = groupMessagesService.getGroupMessages();
        List<GroupMessagesResponse> groupMessagesResponseList = new ArrayList<>();
        for (GroupMessages groupMessages : groupMessagesList) {
            groupMessagesResponseList.add(new GroupMessagesResponse(groupMessages));
        }
        return ResponseEntity.ok(groupMessagesResponseList);
    }

    @GetMapping
    public ResponseEntity<List<GroupMessagesResponse>> getGroupMessages() {
        List<GroupMessages> groupMessagesList = groupMessagesService.getGroupMessages();
        List<GroupMessagesResponse> groupMessagesResponseList = new ArrayList<>();
        for (GroupMessages groupMessages : groupMessagesList) {
            groupMessagesResponseList.add(new GroupMessagesResponse(groupMessages));
        }
        return ResponseEntity.ok(groupMessagesResponseList);
    }

}
