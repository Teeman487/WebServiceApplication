package com.wsapp.wsapplication.service;

import com.wsapp.wsapplication.controller.AddResponse;
import com.wsapp.wsapplication.model.Country;
import com.wsapp.wsapplication.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries()   // http://localhost:8080/getcountries
    {
        List<Country> countries=countryRepository.findAll();
        return countries;
    }

    public Country getCountryByID(int id)  // http://localhost:8080/getcountries/1
    {
//        Country country = countryRepository.findById(id).get();
//        return country;
        // Preferred for mocking
        List<Country> countries= countryRepository.findAll();
        Country country = null;
        for(Country con:countries)
        {
            if(con.getId()==id)
                country=con;
        }
        return country;
    }

    public Country getCountryByName(String countryName) // http://localhost:8082/getcountries/countryname?name=india
    {
        List<Country> countries= countryRepository.findAll();
        Country country = null;
        for(Country con:countries)
        {
            if(con.getCountryName().equalsIgnoreCase(countryName))
                country=con;
        }
        return country;
    }

    public Country addCountry(Country country)   // http://localhost:8080/addcountry
    {
        country.setId(getMaxId());
        countryRepository.save(country);
        return country;

    }
    // Utility method to get max id
    public  int getMaxId()
    {
        return countryRepository.findAll().size()+1;
    }

    public Country updateCountry(Country country) // http://localhost:8080/updatecountry
    {
          countryRepository.save(country);
          return country;
    }

    /*public AddResponse deleteCountry(int id)*/
    public AddResponse deleteCountry(Country country) {
        countryRepository.delete(country);
        AddResponse response = new AddResponse();
        response.setMsg("Country deleted...");
        response.setId(country.getId());
        return response;
    }
}
