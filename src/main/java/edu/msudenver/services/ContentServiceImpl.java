package edu.msudenver.services;


import edu.msudenver.exceptions.ResourceNotFoundException;
import edu.msudenver.models.*;
import edu.msudenver.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CatalogServiceImpl catalogService;

    @Autowired
    private CellServiceImpl cellService;

    @Override
    public ContentResponse createContent(ContentRequest contentRequest) {
        Long cellId = contentRequest.getCellId();
        Long zoneId = contentRequest.getZoneId();

        // Check if the cell exists
        Cell cell = cellService.getCellById(cellId, zoneId);

        // Create the content entity
        Content content = new Content();
        content.setContentId(contentRequest.getContentId());
        content.setProfileId(contentRequest.getProfileId());
        content.setQuantity(contentRequest.getQuantity());
        content.setType(contentRequest.getType());
        content.setCellId(cellId);
        content.setZoneId(zoneId);

        // Save the content entity
        content = contentRepository.save(content);

        // Get the catalog response
        Catalog catalog = catalogService.getCatalogById(contentRequest.getContentId());
        CatalogResponse catalogResponse = new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(), catalog.getDefense(),
                catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(), catalog.isCanBeLooted(),
                catalog.getLoot(), catalog.getLootSize());

        // Create the cell response
        ZoneResponse zoneResponse = new ZoneResponse(cell.getZone().getZoneId());
        CellResponse cellResponse = new CellResponse(cell.getId(), cell.getXcoordinate(), cell.getYcoordinate(), zoneResponse);

        // Create the content response
        ContentResponse contentResponse = new ContentResponse(catalogResponse, cellResponse, content.getContentId(),
                content.getProfileId(), content.getQuantity(), content.getType());

        return contentResponse;
    }

    @Override
    public ContentResponse getContentById(long contentId, long zoneId) {
        Content content = contentRepository.findByContentIdAndZoneId(contentId, zoneId);
        if (content == null) {
            throw new ResourceNotFoundException("Content", "contentId", contentId);
        }

        Catalog catalog = catalogService.getCatalogById(content.getContentId());
        CatalogResponse catalogResponse = new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(), catalog.getDefense(),
                catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(), catalog.isCanBeLooted(),
                catalog.getLoot(), catalog.getLootSize());


        Cell cell = cellService.getCellById(content.getCellId(), zoneId);
        ZoneResponse zoneResponse = new ZoneResponse(cell.getZone().getZoneId());
        CellResponse cellResponse = new CellResponse(cell.getId(), cell.getXcoordinate(), cell.getYcoordinate(), zoneResponse);

        ContentResponse contentResponse = new ContentResponse(catalogResponse, cellResponse, content.getContentId(),
                content.getProfileId(), content.getQuantity(), content.getType());

        return contentResponse;
    }

    @Override
    public List<ContentResponse> getAllContentByCellIdAndZoneId(long cellId, long zoneId) {
        List<Content> contentList = contentRepository.findByCellIdAndZoneId(cellId, zoneId);

        List<ContentResponse> contentResponseList = new ArrayList<>();

        for (Content content : contentList) {
            Catalog catalog = catalogService.getCatalogById(content.getContentId());
            CatalogResponse catalogResponse = new CatalogResponse(catalog.getCatalogId(), catalog.getName(), catalog.getType(),
                    catalog.getLevel(), catalog.getHealth(), catalog.getSpeed(), catalog.getAttack(), catalog.getDefense(),
                    catalog.getExpGranted(), catalog.isCanBeEquipped(), catalog.isEquipped(), catalog.isCanBeLooted(),
                    catalog.getLoot(), catalog.getLootSize());

            Cell cell = cellService.getCellById(content.getCellId(), zoneId);
            ZoneResponse zoneResponse = new ZoneResponse(cell.getZone().getZoneId());
            CellResponse cellResponse = new CellResponse(cell.getId(), cell.getXcoordinate(), cell.getYcoordinate(), zoneResponse);

            ContentResponse contentResponse = new ContentResponse(catalogResponse, cellResponse, content.getContentId(),
                    content.getProfileId(), content.getQuantity(), content.getType());

            contentResponseList.add(contentResponse);
        }

        return contentResponseList;
    }

    @Override
    public void deleteContentById(long contentId, long zoneId) {
        Content content = contentRepository.findByContentIdAndZoneId(contentId, zoneId);
        if (content == null) {
            throw new ResourceNotFoundException("Content", "contentId", contentId);
        }

        contentRepository.deleteById(content.getId());
    }
}
