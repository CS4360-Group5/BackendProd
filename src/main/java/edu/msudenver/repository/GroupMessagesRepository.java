package edu.msudenver.repository;


import edu.msudenver.models.chats.GroupMessages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMessagesRepository extends JpaRepository<GroupMessages, Long> {
    List<GroupMessages> findAllByGroupId(Long groupId);
}
