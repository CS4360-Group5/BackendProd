package edu.msudenver.controllers;

import edu.msudenver.models.Inventory;
import edu.msudenver.models.InventoryRequest;
import edu.msudenver.models.InventoryResponse;
import edu.msudenver.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<List<InventoryResponse>> getInventory() {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        List<InventoryResponse> inventoryResponseList = new ArrayList<>();

        for (Inventory inventory : inventoryList) {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setInventoryId(inventory.getId());
            inventoryResponse.setCatalogId(inventory.getCatalogId());
            inventoryResponse.setEquipped(inventory.getEquipped());
            inventoryResponse.setName(inventory.getName());
            inventoryResponse.setQuantity(inventory.getQuantity());
            inventoryResponse.setType(inventory.getType());

            inventoryResponseList.add(inventoryResponse);
        }

        return ResponseEntity.ok().body(inventoryResponseList);
    }

    @PostMapping
    public ResponseEntity<InventoryResponse> addInventory(@RequestBody @Valid InventoryRequest inventoryRequest) {
        Inventory inventory = new Inventory();
        inventory.setCatalogId(inventoryRequest.getCatalogId());
        inventory.setEquipped(inventoryRequest.getEquipped());
        inventory.setName(inventoryRequest.getName());
        inventory.setProfileId(inventoryRequest.getProfileId());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setType(inventoryRequest.getType());

        Inventory savedInventory = inventoryService.addInventory(inventory);

        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setInventoryId(savedInventory.getId());
        inventoryResponse.setCatalogId(savedInventory.getCatalogId());
        inventoryResponse.setEquipped(savedInventory.getEquipped());
        inventoryResponse.setName(savedInventory.getName());
        inventoryResponse.setQuantity(savedInventory.getQuantity());
        inventoryResponse.setType(savedInventory.getType());

        return new ResponseEntity<>(inventoryResponse, HttpStatus.CREATED);
    }

    @PutMapping("/equip/{inventoryId}/profile/{profileId}")
    public InventoryResponse InventoryProfileEquip(@PathVariable Long inventoryId, @PathVariable Long profileId, @RequestBody InventoryRequest inventoryRequest) {
        Inventory inventory = inventoryService.findById(inventoryId);
        inventory.setProfileId(profileId);
        inventory.setCatalogId(inventoryRequest.getCatalogId());
        inventory.setEquipped(inventoryRequest.getEquipped());
        inventory.setName(inventoryRequest.getName());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setType(inventoryRequest.getType());
        inventory = inventoryService.addInventory(inventory);

        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setInventoryId(inventory.getId());
        inventoryResponse.setCatalogId(inventory.getCatalogId());
        inventoryResponse.setEquipped(inventory.getEquipped());
        inventoryResponse.setName(inventory.getName());
        inventoryResponse.setQuantity(inventory.getQuantity());
        inventoryResponse.setType(inventory.getType());

        return inventoryResponse;
    }

    @GetMapping("/profile/{profileId}")
    public List<InventoryResponse> getProfileInventory(@PathVariable Long profileId) {
        List<Inventory> inventoryList = inventoryService.getInventoryByProfileId(profileId);
        List<InventoryResponse> inventoryResponseList = new ArrayList<>();
        for (Inventory inventory : inventoryList) {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setInventoryId(inventory.getId());
            inventoryResponse.setCatalogId(inventory.getCatalogId());
            inventoryResponse.setEquipped(inventory.getEquipped());
            inventoryResponse.setName(inventory.getName());
            inventoryResponse.setQuantity(inventory.getQuantity());
            inventoryResponse.setType(inventory.getType());
            inventoryResponseList.add(inventoryResponse);
        }
        return inventoryResponseList;
    }

    @GetMapping("/{inventoryId}")
    public InventoryResponse getInventoryById(@PathVariable Long inventoryId) {
        Inventory inventory = inventoryService.findById(inventoryId);
        InventoryResponse response = new InventoryResponse();
        response.setInventoryId(inventory.getId());
        response.setCatalogId(inventory.getCatalogId());
        response.setEquipped(inventory.getEquipped());
        response.setName(inventory.getName());
        response.setQuantity(inventory.getQuantity());
        response.setType(inventory.getType());
        return response;
    }

    @DeleteMapping("/{inventoryId}/profile/{profileId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long inventoryId, @PathVariable Long profileId) {
        inventoryService.deleteItemByIdAndProfileId(profileId, inventoryId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{inventoryId}/profile/{profileId}/edit")
    public InventoryResponse changeQuantityType(@PathVariable Long inventoryId, @PathVariable Long profileId,
                                                @RequestBody InventoryRequest inventoryRequest) {
        Inventory inventory = inventoryService.findByIdAndProfileId(inventoryId, profileId);

        inventory.setCatalogId(inventoryRequest.getCatalogId());
        inventory.setEquipped(inventoryRequest.getEquipped());
        inventory.setName(inventoryRequest.getName());
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setType(inventoryRequest.getType());

        inventory = inventoryService.addInventory(inventory);

        return new InventoryResponse(
                inventory.getId(),
                inventory.getCatalogId(),
                inventory.getEquipped(),
                inventory.getName(),
                inventory.getQuantity(),
                inventory.getType()
        );
    }
}
