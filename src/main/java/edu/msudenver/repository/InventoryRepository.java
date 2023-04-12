package edu.msudenver.repository;

import edu.msudenver.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findByProfileId(Long profileId);
    void deleteByInventoryIdAndProfileId(Long inventoryId, Long profileId);
    Inventory findByInventoryIdAndProfileId(Long inventoryId, Long profileId);
}