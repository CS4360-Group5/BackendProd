package edu.msudenver.models;

import javax.validation.constraints.NotBlank;

public class CityRequest {

    @NotBlank
    private String countryCode;

    @NotBlank
    private String name;

    @NotBlank
    private String postalCode;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}