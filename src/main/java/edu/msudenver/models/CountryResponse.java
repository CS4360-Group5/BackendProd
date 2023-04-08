package edu.msudenver.models;

public class CountryResponse {
    private final String countryCode;
    private final String countryName;

    public CountryResponse(Country country) {
        this.countryCode = country.getCountryCode();
        this.countryName = country.getCountryName();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }
}