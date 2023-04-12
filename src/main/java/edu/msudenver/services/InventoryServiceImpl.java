package edu.msudenver.services;

import edu.msudenver.exceptions.ResourceNotFoundException;
import edu.msudenver.models.Inventory;
import edu.msudenver.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    @Override
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }
    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    @Override
    public Inventory findById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory", "inventoryId", id));
    }
    @Override
    public List<Inventory> getInventoryByProfileId(Long profileId) {
        return inventoryRepository.findByProfileId(profileId);
    }

    @Override
    public void deleteItemByIdAndProfileId(Long profileId, Long id) {
        inventoryRepository.deleteInventoryByProfileIdAndId(profileId, id);
    }
    @Override
    public Inventory findByIdAndProfileId(Long id, Long profileId) throws ResourceNotFoundException {
        Inventory inventory = inventoryRepository.findByIdAndProfileId(id, profileId);
        if (inventory == null) {
            throw new ResourceNotFoundException("Inventory", "inventoryId and profileId", id + " and " + profileId);
        }
        return inventory;
    }
}
