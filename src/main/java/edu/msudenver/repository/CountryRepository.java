package edu.msudenver.repository;

import edu.msudenver.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByCountryCode(String countryCode);
    void deleteByCountryCode(String countryCode);
}