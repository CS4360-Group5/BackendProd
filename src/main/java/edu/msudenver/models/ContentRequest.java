package edu.msudenver.models;

public class ContentRequest {

    private Long cellId;
    private Long contentId;
    private Long profileId;
    private Integer quantity;
    private String type;
    private Long zoneId;

    public ContentRequest() {}

    public ContentRequest(Long cellId, Long contentId, Long profileId, Integer quantity, String type, Long zoneId) {
        this.cellId = cellId;
        this.contentId = contentId;
        this.profileId = profileId;
        this.quantity = quantity;
        this.type = type;
        this.zoneId = zoneId;
    }

    public Long getCellId() {
        return cellId;
    }

    public void setCellId(Long cellId) {
        this.cellId = cellId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
}
