package edu.msudenver.repository;

import edu.msudenver.models.Cell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {
    Cell findByIdAndZoneZoneId(Long id, Long zoneId);
}
