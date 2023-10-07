/*
package com.wsapp.wsapplication.controller;

import com.wsapp.wsapplication.model.Country;
import com.wsapp.wsapplication.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/getcountries") // http://localhost:8080/getcountries
    public List getCountries()   // Getting All Countries
    {
        return countryService.getAllCountries();  // Import biz logic from  (countryService method) --Achieve loosely coupling
    }

    @GetMapping("/getcountries/{id}") // http://localhost:8080/getcountries/1
    public Country getCountryByID(@PathVariable(value="id") int id) // Getting specific country by ID
    {
        return   countryService.getCountryByID(id);
    }

    @GetMapping("/getcountries/countryname") // http://localhost:8080/getcountries/countryname?name=india
    public Country getCountryByName(@RequestParam(value="name") String countryName)  // Getting country by Queries
    {
        return   countryService.getCountrybyName(countryName);
    }

    @PostMapping("/addcountry") // http://localhost:8080/addcountry
    public Country addCountry(@Valid @RequestBody Country country)
    {
        return   countryService.addCountry(country);
    }

    @PutMapping("/updatecountry") // http://localhost:8080/updatecountry
    public Country updateCountry(@RequestBody Country country)
    {
        return   countryService.updateCountry(country);
    }

    @DeleteMapping("/deletecountry/{id}")  //http://localhost:8080/deletecountry/4
    public AddResponse deleteCountry( @PathVariable(value="id") int id)
    {
        return countryService.deleteCountry(id);

    }
}
*/
