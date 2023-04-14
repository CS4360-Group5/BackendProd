package edu.msudenver.repository;

import edu.msudenver.models.chats.GroupMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Long> {
    List<GroupMembers> findByGroupId(Long groupId);
}
