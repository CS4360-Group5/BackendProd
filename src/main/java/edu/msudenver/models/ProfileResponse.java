package edu.msudenver.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "account","classType","gender","active","origins","profileId", "profileName" })
public class ProfileResponse {

    private Long profileId;
    private String profileName;
    private String classType;
    private String gender;
    private String origins;
    private boolean isActive;
    private AccountResponse account;

    private Long accountId;


    public ProfileResponse(Long profileId, String profileName, String classType, String gender, String origins, boolean isActive, AccountResponse account) {

        this.account = account;
        this.classType = classType;
        this.gender = gender;
        this.isActive = isActive;
        this.origins = origins;
        this.profileId = profileId;
        this.profileName = profileName;
    }

    public ProfileResponse() {

    }

    public String getProfileName() {
        return profileName;
    }
    public Long getProfileId() {
        return profileId;
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

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrigins(String origins) {
        this.origins = origins;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAccount(AccountResponse account) {
        this.account = account;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
