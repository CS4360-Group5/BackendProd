package edu.msudenver.services;


import edu.msudenver.models.Country;
import edu.msudenver.models.CountryRequest;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    Country getCountryByCode(String countryCode);
    Country addCountry(String countryCode, String countryName);
    Country updateCountryByCode(String countryCode, CountryRequest countryRequest);
    void deleteCountryByCode(String countryCode);
}
