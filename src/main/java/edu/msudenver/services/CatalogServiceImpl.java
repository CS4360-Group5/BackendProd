package edu.msudenver.services;

import edu.msudenver.models.Catalog;
import edu.msudenver.models.CatalogRequest;
import edu.msudenver.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public Catalog createCatalog(CatalogRequest catalogRequest) {
        Catalog catalog = new Catalog();
        catalog.setName(catalogRequest.getName());
        catalog.setType(catalogRequest.getType());
        catalog.setLevel(catalogRequest.getLevel());
        catalog.setHealth(catalogRequest.getHealth());
        catalog.setSpeed(catalogRequest.getSpeed());
        catalog.setAttack(catalogRequest.getAttack());
        catalog.setDefense(catalogRequest.getDefense());
        catalog.setExpGranted(catalogRequest.getExpGranted());
        catalog.setCanBeEquipped(catalogRequest.isCanBeEquipped());
        catalog.setEquipped(catalogRequest.isEquipped());
        catalog.setCanBeLooted(catalogRequest.isCanBeLooted());
        catalog.setLoot(catalogRequest.getLoot());
        catalog.setLootSize(catalogRequest.getLootSize());
        return catalogRepository.save(catalog);
    }

    @Override
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog getCatalogById(long id) {
        return catalogRepository.findById(id);
    }
}
