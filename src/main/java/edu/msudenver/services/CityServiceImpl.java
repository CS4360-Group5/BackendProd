package edu.msudenver.services;

import edu.msudenver.models.City;
import edu.msudenver.models.Country;
import edu.msudenver.repository.CityRepository;
import edu.msudenver.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }
    @Override
    public City createCity(String countryCode, String name, String postalCode) throws EntityNotFoundException {
        Country country = countryRepository.findByCountryCode(countryCode);
        if (country == null) {
            throw new EntityNotFoundException("No country found with code: " + countryCode);
        }
        City city = new City();
        city.setCountry(country);
        city.setName(name);
        city.setPostalCode(postalCode);
        return cityRepository.save(city);
    }
    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}
