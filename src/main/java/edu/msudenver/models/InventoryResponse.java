package edu.msudenver.models;

public class InventoryResponse {
    private Long inventoryId;
    private Long catalogId;
    private Boolean equipped;
    private String name;
    private Integer quantity;
    private String type;

    public InventoryResponse() {
    }

    public InventoryResponse(Long inventoryId, Long catalogId, Boolean equipped, String name, Integer quantity, String type) {
        this.inventoryId = inventoryId;
        this.catalogId = catalogId;
        this.equipped = equipped;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Boolean getEquipped() {
        return equipped;
    }

    public void setEquipped(Boolean equipped) {
        this.equipped = equipped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
