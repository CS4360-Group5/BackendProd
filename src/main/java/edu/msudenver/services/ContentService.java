package edu.msudenver.services;

import edu.msudenver.models.CellResponse;
import edu.msudenver.models.Content;
import edu.msudenver.models.ContentRequest;
import edu.msudenver.models.ContentResponse;

import java.util.List;


public interface ContentService {
    ContentResponse createContent(ContentRequest contentRequest);
    ContentResponse getContentById(long contentId, long zoneId);
    List<ContentResponse> getAllContentByCellIdAndZoneId(long cellId, long zoneId);
    void deleteContentById(long contentId, long zoneId);
}