package edu.msudenver.models;

public class ContentPatchRequest {
    private String action;
    private String direction;
    private Long requestProfileId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getRequestProfileId() {
        return requestProfileId;
    }

    public void setRequestProfileId(Long requestProfileId) {
        this.requestProfileId = requestProfileId;
    }
}
