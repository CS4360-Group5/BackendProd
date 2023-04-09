package edu.msudenver.services;

import edu.msudenver.models.Zone;

import java.util.List;

public interface ZoneService {
    List<Zone> getAllZones();
    Zone createZone();
    Zone getZoneById(long zoneId);
    void deleteZone(long zoneId);
}