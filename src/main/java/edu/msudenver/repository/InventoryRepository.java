package edu.msudenver.repository;

import edu.msudenver.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProfileId(Long profileId);
    void deleteInventoryByProfileIdAndId(Long profileId, Long id);
    Inventory findByIdAndProfileId(Long id, Long profileId);
}