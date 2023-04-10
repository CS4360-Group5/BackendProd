package edu.msudenver.services;

import edu.msudenver.models.Cell;

public interface CellService {
    public Cell getCellById(long cellId, long zoneId);
    public Cell createCell(long zoneId, int xCoordinate, int yCoordinate);
}
