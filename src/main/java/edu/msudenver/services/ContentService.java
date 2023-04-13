package edu.msudenver.services;

import edu.msudenver.models.CellResponse;
import edu.msudenver.models.Content;
import edu.msudenver.models.ContentRequest;
import edu.msudenver.models.ContentResponse;

import java.util.List;


public interface ContentService {
    ContentResponse createContent(ContentRequest contentRequest);
    ContentResponse getContentById(Long contentId);
    List<ContentResponse> getAllContentByCellIdAndZoneId(long cellId, long zoneId);
    void deleteContentById(long contentId);

    List<ContentResponse> getContentByRadiusAndType(Long zoneId, Long cellId, int radius, String type);
}