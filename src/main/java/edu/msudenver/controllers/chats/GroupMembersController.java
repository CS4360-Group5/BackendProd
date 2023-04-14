package edu.msudenver.controllers.chats;

import edu.msudenver.models.chats.GroupMembers;
import edu.msudenver.models.chats.GroupMembersRequest;
import edu.msudenver.models.chats.GroupMembersResponse;
import edu.msudenver.services.GroupMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chats/members")
public class GroupMembersController {

    @Autowired
    private GroupMembersService groupMembersService;

    @GetMapping("/{groupId}")
    public ResponseEntity<List<GroupMembersResponse>> getGroupMembers(@PathVariable Long groupId) {
        List<GroupMembers> groupMembersList = groupMembersService.getGroupMembersByGroupId(groupId);
        List<GroupMembersResponse> groupMembersResponseList = new ArrayList<>();
        for (GroupMembers groupMembers : groupMembersList) {
            GroupMembersResponse groupMembersResponse = new GroupMembersResponse(groupMembers);
            groupMembersResponseList.add(groupMembersResponse);
        }
        return ResponseEntity.ok(groupMembersResponseList);
    }

    @PostMapping
    public ResponseEntity<List<GroupMembersResponse>> createGroupMembers(@RequestBody GroupMembersRequest groupMembersRequest) {
        GroupMembers savedGroupMembers = groupMembersService.createGroupMembers(groupMembersRequest);
        List<GroupMembersResponse> groupMembersResponseList = groupMembersService.getGroupMembersByGroupId(savedGroupMembers.getGroupId())
                .stream()
                .map(GroupMembersResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(groupMembersResponseList);
    }

    @PostMapping("/external/createone")
    public ResponseEntity<GroupMembersResponse> createGroupMembersExternal(@RequestBody GroupMembersRequest groupMembersRequest) {
        GroupMembers savedGroupMembers = groupMembersService.createGroupMembers(groupMembersRequest);
        GroupMembersResponse groupMembersResponse = new GroupMembersResponse(savedGroupMembers);
        return ResponseEntity.ok(groupMembersResponse);
    }

    @GetMapping("/external/getall")
    public ResponseEntity<List<GroupMembersResponse>> getGroupMembersExternal() {
        List<GroupMembers> groupMembersList = groupMembersService.getGroupMembers();
        List<GroupMembersResponse> groupMembersResponseList = new ArrayList<>();
        for (GroupMembers groupMembers : groupMembersList) {
            GroupMembersResponse groupMembersResponse = new GroupMembersResponse(groupMembers);
            groupMembersResponseList.add(groupMembersResponse);
        }
        return ResponseEntity.ok(groupMembersResponseList);
    }

}
