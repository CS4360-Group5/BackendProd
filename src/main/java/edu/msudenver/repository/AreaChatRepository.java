package edu.msudenver.repository;

import edu.msudenver.models.chats.AreaChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AreaChatRepository extends JpaRepository<AreaChat, Long> {

    List<AreaChat> findByDestinationIdOrderByChatTimeAsc(String destinationId);
    List<AreaChat> findByFromId(String fromId);
    List<AreaChat> findByDestinationIdAndChatTimeGreaterThan(String destinationId, Date date);
}