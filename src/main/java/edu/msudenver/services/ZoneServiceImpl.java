package edu.msudenver.services;

import edu.msudenver.models.Zone;
import edu.msudenver.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }
    @Override
    public Zone createZone() {
        Zone zone = new Zone();
        zone = zoneRepository.save(zone);
        return zone;
    }
    @Override
    public Zone getZoneById(long zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        return zone;
    }
    @Override
    public void deleteZone(long zoneId) {
        zoneRepository.deleteById(zoneId);
    }
}