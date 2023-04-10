package edu.msudenver.services;

import edu.msudenver.exceptions.ResourceNotFoundException;
import edu.msudenver.models.Cell;
import edu.msudenver.models.Zone;
import edu.msudenver.repository.CellRepository;
import edu.msudenver.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CellServiceImpl implements CellService {

    @Autowired
    private CellRepository cellRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    public Cell getCellById(long cellId, long zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone == null) {
            throw new ResourceNotFoundException("Zone", "zoneId", zoneId);
        }
        Cell cell = cellRepository.findByIdAndZoneZoneId(cellId, zoneId);
        if (cell == null) {
            throw new ResourceNotFoundException("Cell", "cellId", cellId);
        }
        return cell;
    }

    @Override
    public Cell createCell(long zoneId, int xcoordinate, int ycoordinate) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone == null) {
            throw new ResourceNotFoundException("Zone", "zoneId", zoneId);
        }
        Cell cell = new Cell();
        cell.setXcoordinate(xcoordinate);
        cell.setYcoordinate(ycoordinate);
        cell.setZone(zone);
        return cellRepository.save(cell);
    }
}
