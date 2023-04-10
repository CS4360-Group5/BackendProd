package edu.msudenver.controllers;

import edu.msudenver.models.*;
import edu.msudenver.services.CellService;
import edu.msudenver.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zones/{zoneId}/cells")
public class CellController {

    @Autowired
    private CellService cellService;
    @Autowired
    private ZoneService zoneService;

    @GetMapping("/{cellId}")
    public ResponseEntity<CellResponse> getCell(@PathVariable Long zoneId, @PathVariable Long cellId) {
        Cell cell = cellService.getCellById(zoneId, cellId);
        CellResponse cellResponse = new CellResponse(cell.getId(), cell.getXcoordinate(), cell.getYcoordinate(), new ZoneResponse(cell.getZone().getZoneId()));
        return ResponseEntity.ok(cellResponse);
    }

    @PostMapping
    public ResponseEntity<CellResponse> createCell(@PathVariable Long zoneId, @RequestBody CellRequest cellRequest) {
        Cell cell = cellService.createCell(zoneId, cellRequest.getXcoordinate(), cellRequest.getYcoordinate());
        Zone zone = zoneService.getZoneById(zoneId);
        ZoneResponse zoneResponse = new ZoneResponse(zone.getZoneId());
        CellResponse cellResponse = new CellResponse(cell.getId(), cell.getXcoordinate(), cell.getYcoordinate(), zoneResponse);
        return ResponseEntity.ok(cellResponse);
    }

}
