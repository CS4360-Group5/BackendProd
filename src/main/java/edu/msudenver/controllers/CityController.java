package edu.msudenver.controllers;

import edu.msudenver.models.*;
import edu.msudenver.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityResponse>> getCities() {
        List<City> cities = cityService.getAllCities();
        List<CityResponse> cityResponses = cities.stream()
                .map(city -> new CityResponse(city.getCountry(), city.getName(), city.getPostalCode()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(cityResponses);
    }

    @PostMapping
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequest) {
        City city = cityService.createCity(cityRequest.getCountryCode(), cityRequest.getName(), cityRequest.getPostalCode());
        CityResponse cityResponse = new CityResponse(city.getCountry(), city.getName(), city.getPostalCode());
        return ResponseEntity.ok(cityResponse);
    }
}
