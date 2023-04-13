package edu.msudenver.repository;

import edu.msudenver.models.chats.WorldChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorldChatRepository extends JpaRepository<WorldChat, Long> {
    List<WorldChat> findByZoneId(Long zoneId);
}
