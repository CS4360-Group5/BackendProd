package edu.msudenver.services;

import edu.msudenver.models.City;

import java.util.List;

public interface CityService {

    City createCity(String countryCode, String name, String postalCode);
    List<City> getAllCities();
}
