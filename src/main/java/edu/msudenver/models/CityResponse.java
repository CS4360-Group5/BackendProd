package edu.msudenver.models;

public class CityResponse {

    private CountryResponse country;
    private String name;
    private String postalCode;

    public CityResponse(Country country, String name, String postalCode) {
        this.country = new CountryResponse(country);
        this.name = name;
        this.postalCode = postalCode;
    }

    public CountryResponse getCountry() {
        return country;
    }

    public void setCountry(CountryResponse country) {
        this.country = country;
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
