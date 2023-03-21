package edu.msudenver.models;

public class ProfileResponse {

    private Long profileId;
    private String profileName;
    private String classType;
    private String gender;
    private String origins;
    private boolean isActive;
    private AccountResponse account;

    public ProfileResponse(Long profileId, String profileName, String classType, String gender, String origins, boolean isActive, AccountResponse account) {

        this.profileId = profileId;
        this.profileName = profileName;
        this.classType = classType;
        this.gender = gender;
        this.origins = origins;
        this.isActive = isActive;
        this.account = account;
    }

    public Long getProfileId() {
        return profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getClassType() {
        return classType;
    }

    public String getGender() {
        return gender;
    }

    public String getOrigins() {
        return origins;
    }

    public boolean isActive() {
        return isActive;
    }

    public AccountResponse getAccount() {
        return account;
    }
}
