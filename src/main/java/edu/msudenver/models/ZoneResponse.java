package edu.msudenver.models;

public class ZoneResponse {
    private Long zoneId;

    public ZoneResponse(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
