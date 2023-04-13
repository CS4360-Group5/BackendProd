package edu.msudenver.controllers;

import edu.msudenver.exceptions.ResourceNotFoundException;
import edu.msudenver.models.*;
import edu.msudenver.repository.ContentRepository;
import edu.msudenver.services.CatalogService;
import edu.msudenver.services.CellService;
import edu.msudenver.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/zones/{zoneId}/cells/{cellId}/contents")
public class ContentController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private CellService cellService;

    @GetMapping
    public ResponseEntity<List<ContentResponse>> getContentByRadiusAndType(@PathVariable Long zoneId, @PathVariable Long cellId,
                                                                           @RequestParam Integer radius, @RequestParam String type) {
        List<ContentResponse> contentResponseList = contentService.getContentByRadiusAndType(zoneId, cellId, radius, type);
        return ResponseEntity.ok(contentResponseList);
    }

    @PostMapping
    public ContentResponse createContent(ContentRequest contentRequest) {
        Content content = new Content();
        content.setContentId(contentRequest.getContentId());
        content.setProfileId(contentRequest.getProfileId());
        content.setQuantity(contentRequest.getQuantity());
        content.setType(contentRequest.getType());
        content.setCellId(contentRequest.getCellId());
        content.setZoneId(contentRequest.getZoneId());

        Content savedContent = contentRepository.save(content);

        Catalog catalog = catalogService.getCatalogById(savedContent.getContentId());
        CatalogResponse catalogResponse = new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(), catalog.getDefense(),
                catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(), catalog.isCanBeLooted(),
                catalog.getLoot(), catalog.getLootSize());

        Cell cell = cellService.getCellById(savedContent.getCellId(), savedContent.getZoneId());
        ZoneResponse zoneResponse = new ZoneResponse(cell.getZone().getZoneId());
        CellResponse cellResponse = new CellResponse(cell.getId(), cell.getXcoordinate(), cell.getYcoordinate(), zoneResponse);

        ContentResponse contentResponse = new ContentResponse(catalogResponse, cellResponse, savedContent.getContentId(),
                savedContent.getProfileId(), savedContent.getQuantity(), savedContent.getType());

        return contentResponse;
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<ContentResponse> getContentbyContentId(@PathVariable long contentId) {
        ContentResponse contentResponse = contentService.getContentById(contentId);
        return ResponseEntity.ok(contentResponse);
    }

    @DeleteMapping("/{contentId}")
    public ResponseEntity<?> deleteContent(@PathVariable long contentId) {
        ContentResponse content = contentService.getContentById(contentId);
        if (content == null) {
            throw new ResourceNotFoundException("Content", "id", contentId);
        }
        contentService.deleteContentById(contentId);
        return ResponseEntity.ok().build();
    }



}
