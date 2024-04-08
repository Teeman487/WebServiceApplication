package com.wsapp.wsapplication.controller;

import com.wsapp.wsapplication.model.Country;
import com.wsapp.wsapplication.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CountryController1 {
    CountryService countryService;
    public CountryController1(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getcountries") // http://localhost:8082/getcountries
    public List getCountries()   // Getting All Countries
    {
        return countryService.getAllCountries();  // Import biz logic from  (countryService method) --Achieve loosely coupling
    }

    @GetMapping("/getcountries/{id}") // http://localhost:8082/getcountries/1
    public Country getCountryByID(@PathVariable(value="id") int id) // Getting specific country by ID
    {
        return   countryService.getCountryByID(id);
    }

    @GetMapping("/getcountries/countryname") // http://localhost:8080/getcountries/countryname?name=india
    public Country getCountryByName(@RequestParam(value="name") String countryName)  // Getting country by Queries
    {
        return   countryService.getCountryByName(countryName);
    }

    @PostMapping("/addcountry") // http://localhost:8082/addcountry
    public Country addCountry(@Valid @RequestBody Country country)
    {
        return   countryService.addCountry(country);
    }

    @PutMapping("/updatecountry/{id}") // http://localhost:8080/updatecountry
    public Country updateCountry(@PathVariable(value = "id") int id, @Valid @RequestBody Country country)
    {
       Country existCountry = countryService.getCountryByID(id);
       existCountry.setCountryName(country.getCountryName());
       existCountry.setCountryCapital(country.getCountryCapital());

       return countryService.updateCountry(existCountry);

    }

    @DeleteMapping("/deletecountry/{id}")  //http://localhost:8080/deletecountry/4
    public Country deleteCountry(@PathVariable("id") int id)
    {
        Country country = null;
         country =  countryService.getCountryByID(id);
         countryService.deleteCountry(country);
         return country;

    }
}
