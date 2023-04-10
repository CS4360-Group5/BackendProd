package edu.msudenver.controllers;

import edu.msudenver.models.Catalog;
import edu.msudenver.models.CatalogRequest;
import edu.msudenver.models.CatalogResponse;
import edu.msudenver.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping
    public ResponseEntity<CatalogResponse> createCatalog(@RequestBody CatalogRequest catalogRequest) {
        Catalog catalog = catalogService.createCatalog(catalogRequest);
        CatalogResponse catalogResponse = new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(), catalog.getDefense(),
                catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(), catalog.isCanBeLooted(),
                catalog.getLoot(), catalog.getLootSize());
        return ResponseEntity.ok(catalogResponse);
    }

    @GetMapping
    public ResponseEntity<List<CatalogResponse>> getAllCatalogs() {
        List<Catalog> catalogs = catalogService.getAllCatalogs();
        List<CatalogResponse> catalogResponses = catalogs.stream()
                .map(catalog -> new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                        catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(),
                        catalog.getDefense(), catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(),
                        catalog.isCanBeLooted(), catalog.getLoot(), catalog.getLootSize()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(catalogResponses);
    }

    @GetMapping("/{catalogId}")
    public ResponseEntity<CatalogResponse> getCatalogById(@PathVariable Long catalogId) {
        Catalog catalog = catalogService.getCatalogById(catalogId);
        CatalogResponse catalogResponse = new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(), catalog.getDefense(),
                catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(), catalog.isCanBeLooted(),
                catalog.getLoot(), catalog.getLootSize());
        return ResponseEntity.ok(catalogResponse);
    }
}
