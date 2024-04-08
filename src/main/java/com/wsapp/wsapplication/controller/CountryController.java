//package com.wsapp.wsapplication.controller;
//import com.wsapp.wsapplication.model.Country;
//import com.wsapp.wsapplication.service.CountryService1;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//
//public class CountryController {
//    CountryService1 countryService;
//    public CountryController(CountryService1 countryService) {
//        this.countryService = countryService;
//    }
//
//    @GetMapping("/getcountries") // http://localhost:8082/getcountries
//    public ResponseEntity<List<Country>> getCountries()
//    {
//        List<Country> countries=countryService.getAllCountries();;
//        return  new ResponseEntity<List<Country>>(countries, HttpStatus.FOUND);       // contain headers, cookies and all
//    }
//
//    @GetMapping("/getcountries/{id}") // http://localhost:8082/getcountries/1
//    public ResponseEntity<Country> getCountryByID(@PathVariable(value="id") int id) {
//        Country country = countryService.getCountryByID(id);
//        return new ResponseEntity<>(country, HttpStatus.ACCEPTED); // Return the country if ID is valid
//    }
//
//    @GetMapping("/getcountries/countryname") // http://localhost:8082/getcountries/countryname?name=India
//    public ResponseEntity<Country> getCountryByName(@RequestParam(value="name") String countryName)
//    {
//        Country country = countryService.getCountryByName(countryName);
//        return new ResponseEntity<>(country, HttpStatus.ACCEPTED);       // contain headers, cookies and all
//    }
//
//    @PostMapping("/addcountry") // http://localhost:8080/addcountry
//    public ResponseEntity<Country> addCountry(@Valid @RequestBody Country country)
//    {
//        country = countryService.addCountry(country);
//        return new ResponseEntity<Country>(country,HttpStatus.CREATED);
//    }
//    @PutMapping("/updatecountry/{id}") // http://localhost:8082/updatecountry/4
//    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id, @RequestBody Country country)
//    {
//        Country existCountry = countryService.getCountryByID(id); // id: read ---
//        existCountry.setCountryName(country.getCountryName()); //
//        existCountry.setCountryCapital(country.getCountryCapital());  // Passing name and capital
//
//        Country updated_country = countryService.updateCountry(existCountry);
//        return  new ResponseEntity<Country>(updated_country,HttpStatus.OK);
//    }
//    @DeleteMapping(path="/deletecountry/{id}")  //http://localhost:8082/deletecountry/4
//    public ResponseEntity<Country> deleteCountry(@PathVariable("id") int id)
//    {
//        // This logic returns deleted body
//          Country country=null;
//          country=countryService.getCountryByID(id); // 1 External dep-that returns then we can mock it
//          countryService.deleteCountry(country.getId()); // not returning; we cant mock it
//          return  new ResponseEntity<>(country, HttpStatus.GONE);
//    }
//
//}
