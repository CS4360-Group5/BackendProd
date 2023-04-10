package edu.msudenver.models;

public class CellResponse {
    private long id;
    private int xCoordinate;
    private int yCoordinate;
    private ZoneResponse zone;

    public CellResponse(long cellId, int xCoordinate, int yCoordinate, ZoneResponse zone) {
        this.id = cellId;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zone = zone;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long cellId) {
        this.id = cellId;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public ZoneResponse getZone() {
        return zone;
    }

    public void setZone(ZoneResponse zone) {
        this.zone = zone;
    }
}
