package edu.msudenver.models;

public class ContentResponse {

    private CatalogResponse catalog;
    private CellResponse cell;
    private Long contentId;
    private Long profileId;
    private Integer quantity;
    private String type;

    public ContentResponse(CatalogResponse catalog, CellResponse cell, Long contentId, Long profileId, Integer quantity, String type) {
        this.catalog = catalog;
        this.cell = cell;
        this.contentId = contentId;
        this.profileId = profileId;
        this.quantity = quantity;
        this.type = type;
    }

    public CatalogResponse getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogResponse catalog) {
        this.catalog = catalog;
    }

    public CellResponse getCell() {
        return cell;
    }

    public void setCell(CellResponse cell) {
        this.cell = cell;
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
}
