//package com.wsapp.wsapplication.service;
//import com.wsapp.wsapplication.controller.AddResponse;
//import com.wsapp.wsapplication.model.Country;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//@Service
//@Component
//public class CountryService1 {
//    static HashMap<Integer, Country> countryIdMap;   // Temporary Request Mapping
//
//    public  CountryService1() {  //  intend to import data from model
//            countryIdMap=new HashMap<>();
//            Country indiaCountry=new Country(1, "India", "Delhi");
//            Country usaCountry=new Country(2, "USA", "Washington");
//            Country ukCountry=new Country(3, "UK", "London");
//
//            countryIdMap.put(1,indiaCountry);
//            countryIdMap.put(2,usaCountry);
//            countryIdMap.put(3,ukCountry);
//    }
//
//    // create a Temporary Map[Request Mapping]
//    // create instance of the Map
//    // set the map
//
//    public List getAllCountries()   // http://localhost:8082/getcountries  // biz logic is written here
//    {
//        List countries=new ArrayList(countryIdMap.values());  //
//        return countries;
//    }
//
//    public Country getCountryByID(Integer id)  // http://localhost:8082/getcountries/1   // biz logic is written here
//    {
//        if(countryIdMap.containsKey(id))
//        {
//            return countryIdMap.get(id);
//        }
//        return null;
//    }
//
//    public Country getCountryByName(String countryName) // http://localhost:8080/getcountries/countryname?name=india
//    {
//        Country country = null;
//        for(int i:countryIdMap.keySet())   //
//        {
//            if(countryIdMap.get(i).getCountryName().equals(countryName))
//                country=countryIdMap.get(i); // get the country id with the countryName
//        }
//        return country;
//    }
//
//    public Country addCountry(Country country)   // http://localhost:8080/addcountry
//    {
//        country.setId(getMaxId());
//        if(countryIdMap ==null) countryIdMap = new HashMap<>();
//        countryIdMap.put(country.getId(), country);
//        return country;
//
//    }
//
//    // Utility method to get max id
//    public static int getMaxId()
//    {
//        int max=0;
//        for(int id: countryIdMap.keySet())
//            if(max<=id)
//                max=id;
//        return  max+1;
//    }
//
//    public Country updateCountry(Country country) // http://localhost:8080/updatecountry
//    {
//        if(country.getId()>0)  // if id provided in the body is >0
//            countryIdMap.put(country.getId(), country); // the key in Map will auto increse
//        return country;
//    }
//
//    public AddResponse deleteCountry(int id)
//    {
//        countryIdMap.remove(id);  // remove id in the map
//        AddResponse res=new AddResponse();
//        res.setMsg("Country deleted...");
//        res.setId(id); // To know which id is deleted
//        return res;  // Spring Boot auto convert java object to Json format
//
//    }
//}
