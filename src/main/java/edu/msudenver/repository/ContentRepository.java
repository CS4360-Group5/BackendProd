package edu.msudenver.repository;

import edu.msudenver.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findByCellIdAndZoneId(Long cellId, Long zoneId);
    Content findByContentIdAndZoneId(Long contentId, Long zoneId);
    List<Content> findByZoneId(Long zoneId);
}
