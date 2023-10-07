/*
package com.wsapp.wsapplication.service;

import com.wsapp.wsapplication.controller.AddResponse;
import com.wsapp.wsapplication.model.Country;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class CountryService {
    static HashMap<Integer, Country> countryIdMap;   // Temporary Request Mapping

    public  CountryService() {  //  intend to import data from model
            countryIdMap=new HashMap<Integer,Country>();  // countryIdMap(created Map) an instance of HashMap; inorder to set my values
            Country indiaCountry=new Country(1, "India", "Delhi");
            Country usaCountry=new Country(2, "USA", "Washington");
            Country ukCountry=new Country(3, "UK", "London");


            countryIdMap.put(1,indiaCountry);
            countryIdMap.put(2,usaCountry);
            countryIdMap.put(3,ukCountry);
    }
    // create a Temporary Map[Request Mapping]
    // create instance of the Map
    // set the map

    public List getAllCountries()   // http://localhost:8080/getcountries  // biz logic is written here
    {
        List countries=new ArrayList(countryIdMap.values());  //
        return countries;
    }

    public Country getCountryByID(int id)  // http://localhost:8080/getcountries/1   // biz logic is written here
    {
        Country country=countryIdMap.get(id);// countryIdMap is a RequestMap
        return country;
    }

    public Country getCountrybyName(String countryName) // http://localhost:8080/getcountries/countryname?name=india
    {
        Country country = null;
        for(int i:countryIdMap.keySet())   //
        {
            if(countryIdMap.get(i).getCountryName().equals(countryName))
                country=countryIdMap.get(i); // get the country id with the countryName
        }
        return country;
    }

    public Country addCountry(Country country)   // http://localhost:8080/addcountry
    {
        country.setId(getMaxId()); // I set the keyvalue of id into country Map recognized country=4 - keySet values: id countryName Capital instance of addCountry
        countryIdMap.put(country.getId(), country); // countryIdMap.put(country.getId(), [1,countryName,countryCapital])
        return country;

    }

    // Utility method to get max id
    public static int getMaxId()
    {
        int max=0;
        for(int id: countryIdMap.keySet())
            if(max<=id)
                max=id;
        return  max+1;  // 4 - keySet values: id countryName Capital

    }

    public Country updateCountry(Country country) // http://localhost:8080/updatecountry
    {
        if(country.getId()>0)  // if id provided in the body is >0
            countryIdMap.put(country.getId(), country); // the key in Map will auto increse
        return country;
    }

    public AddResponse deleteCountry(int id)
    {
        countryIdMap.remove(id);  // remove id in the map
        AddResponse res=new AddResponse();
        res.setMsg("Country deleted...");
        res.setId(id); // To know which id is deleted
        return res;  // Spring Boot auto convert java object to Json format

    }
}
*/
