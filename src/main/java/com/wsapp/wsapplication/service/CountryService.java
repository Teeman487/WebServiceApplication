package com.wsapp.wsapplication.service;

import com.wsapp.wsapplication.model.Country;
import com.wsapp.wsapplication.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CountryService {
    @Autowired
    CountryRepository countryrep;

    public List<Country> getAllCountries()   // http://localhost:8080/getcountries
    {
        List<Country> countries=countryrep.findAll();
        return countries;
    }

    public Country getCountryByID(int id)  // http://localhost:8080/getcountries/1
    {
     /*Country country=countryIdMap.get(id);
       return country;*/

        // return countryrep.findById(id).get();
        List<Country> countries= countryrep.findAll();
        Country country = null;
        for(Country con:countries)
        {
            if(con.getId()==id)
                country=con;

        }
        return country;
    }

    public Country getCountryByName(String countryName) // http://localhost:8080/getcountries/countryname?name=india
    {
        /*Country country = null;
        for(int i:countryIdMap.keySet())
        {
            if(countryIdMap.get(i).getCountryName().equals(countryName))
                country=countryIdMap.get(i);
        }
         return country;*/

        List<Country> countries= countryrep.findAll();
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
     /* country.setId(getMaxId());
        countryIdMap.put(country.getId(), country);
        return country;*/
        country.setId(getMaxId());
        countryrep.save(country);
        return country;

    }
    // Utility method to get max id
    public  int getMaxId()
    {

       /* int max=0;
        for(int id: countryIdMap.keySet())
            if(max<=id)
                max=id;
        return  max+1;*/
        return countryrep.findAll().size()+1; // countryrep is non static; global variable

    }

    public Country updateCountry(Country country) // http://localhost:8080/updatecountry
    {
        /*if(country.getId()>0)
            countryIdMap.put(country.getId(), country);
        return country;*/
        countryrep.save(country);
        return country;
    }

    /*public AddResponse deleteCountry(int id)*/
    public void deleteCountry(Country country)
    {
        /* countryIdMap.remove(id);
         AddResponse res=new AddResponse();
         res.setMsg("Country deleted...");
         res.setId(id);
         return res;  // Spring Boot auto convert java object to Json format
*/
//        countryrep.deleteById(id);
        countryrep.delete(country);
       /* AddResponse res=new AddResponse();
        res.setMsg("Country deleted...");
        res.setId(id);
        return res;*/

    }
}
