package edu.msudenver.services;

import edu.msudenver.models.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory addInventory(Inventory inventory);
    List<Inventory> getAllInventory();
    Inventory findById(Long id);
    List<Inventory> getInventoryByProfileId(Long profileId);
    void deleteItemByIdAndProfileId(Long profileId, Long id);
    Inventory findByIdAndProfileId(Long inventoryId, Long profileId);
}
