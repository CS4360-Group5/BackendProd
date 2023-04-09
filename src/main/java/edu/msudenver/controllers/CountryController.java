package edu.msudenver.controllers;


import edu.msudenver.models.Country;
import edu.msudenver.models.CountryRequest;
import edu.msudenver.models.CountryResponse;
import edu.msudenver.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getCountries() {
        List<Country> countries = countryService.getAllCountries();
        List<CountryResponse> countryResponses = countries.stream().map(CountryResponse::new).collect(Collectors.toList());
        return new ResponseEntity<>(countryResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCountry(@Valid @RequestBody CountryRequest request) {
        try {
            Country country = countryService.addCountry(request.getCountryCode(), request.getCountryName());
            return ResponseEntity.ok(country);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body("Country code already exists");
        }
    }

    @GetMapping("/{countryCode}")
    public ResponseEntity<Country> getCountry(@PathVariable String countryCode) {
        Country country = countryService.getCountryByCode(countryCode);
        if (country == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(country);
        }
    }

    @PutMapping("/{countryCode}")
    public ResponseEntity<Country> updateCountry(@PathVariable String countryCode, @RequestBody CountryRequest countryRequest) {
        Country updatedCountry = countryService.updateCountryByCode(countryCode, countryRequest);
        if (updatedCountry == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedCountry);
        }
    }

    @Transactional
    @DeleteMapping("/{countryCode}")
    public ResponseEntity<Void> deleteCountryByCode(@PathVariable String countryCode) {
        countryService.deleteCountryByCode(countryCode);
        return ResponseEntity.noContent().build();
    }
}
