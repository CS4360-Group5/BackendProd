package edu.msudenver.controllers;

import edu.msudenver.models.Zone;
import edu.msudenver.models.ZoneResponse;
import edu.msudenver.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping
    public ResponseEntity<List<ZoneResponse>> getZones() {
        List<Zone> zones = zoneService.getAllZones();
        List<ZoneResponse> zoneResponses = zones.stream()
                .map(zone -> new ZoneResponse(zone.getZoneId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(zoneResponses);
    }

    @PostMapping
    public ResponseEntity<ZoneResponse> createZone() {
        Zone zone = zoneService.createZone();
        ZoneResponse zoneResponse = new ZoneResponse(zone.getZoneId());
        return ResponseEntity.ok(zoneResponse);
    }
    @GetMapping("/{zoneId}")
    public ResponseEntity<ZoneResponse> getZone(@PathVariable Long zoneId) {
        Zone zone = zoneService.getZoneById(zoneId);
        if (zone == null) {
            throw new EntityNotFoundException("No zone found with id: " + zoneId);
        }
        ZoneResponse zoneResponse = new ZoneResponse(zone.getZoneId());
        return ResponseEntity.ok(zoneResponse);
    }

    @DeleteMapping("/{zoneId}")
    public ResponseEntity<Void> deleteZone(@PathVariable Long zoneId) {
        zoneService.deleteZone(zoneId);
        return ResponseEntity.noContent().build();
    }
}