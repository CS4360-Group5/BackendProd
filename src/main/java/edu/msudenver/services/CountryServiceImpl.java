package edu.msudenver.services;

import java.util.List;

import edu.msudenver.models.Country;
import edu.msudenver.models.CountryRequest;
import edu.msudenver.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
    @Override
    public Country getCountryByCode(String countryCode) {
        return countryRepository.findByCountryCode(countryCode);
    }
    @Override
    public Country addCountry(String countryCode, String countryName) {
        Country country = new Country();
        country.setCountryCode(countryCode);
        country.setCountryName(countryName);
        return countryRepository.save(country);
    }
    @Override
    public Country updateCountryByCode(String countryCode, CountryRequest countryRequest) {
        Country countryToUpdate = countryRepository.findByCountryCode(countryCode);
        if (countryToUpdate != null) {
            countryToUpdate.setCountryName(countryRequest.getCountryName());
            return countryRepository.save(countryToUpdate);
        } else {
            return null;
        }
    }
    @Override
    public void deleteCountryByCode(String countryCode) {
        countryRepository.deleteByCountryCode(countryCode);
    }
}
