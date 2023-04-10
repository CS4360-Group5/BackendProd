package edu.msudenver.services;

import edu.msudenver.models.Catalog;
import edu.msudenver.models.CatalogRequest;

import java.util.List;

public interface CatalogService {
    Catalog createCatalog(CatalogRequest catalogRequest);
    List<Catalog> getAllCatalogs();
    Catalog getCatalogById(long id);
}