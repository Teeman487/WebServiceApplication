package com.wsapp.wsapplication;
import com.wsapp.wsapplication.controller.CountryController1;
import com.wsapp.wsapplication.model.Country;
import com.wsapp.wsapplication.service.CountryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {ControllerMockitoTests.class})

public class ControllerMockitoTests {
    @Mock
    CountryService countryService;
    @InjectMocks
    CountryController1 countryController;
    List<Country> myCountries;
    Country country;
    //Unit Test Case
    @Test
    @Order(1)
    public void test_getAllCountries()
    {
        myCountries=new ArrayList<>();
        myCountries.add(new Country(1,"India","Delhi"));
        myCountries.add(new Country(2,"USA","Washington"));

        when(countryService.getAllCountries()).thenReturn(myCountries);// Mocking
        List<Country> res=countryController.getCountries();
        //assertEquals(HttpStatus.FOUND,res.getStatusCode()); // verify the response status
        assertEquals(2,res.size());  // no of records from res
    }
    @Test
    @Order(2)
    public void test_getCountryByID()
    {
        country=new Country(2,"USA","Washington");
        int countryID=2;
        when(countryService.getCountryByID(countryID)).thenReturn(country);
        Country res = countryController.getCountryByID(countryID);
      //  assertEquals(HttpStatus.FOUND,res.getStatusCode());
        assertEquals(countryID,res.getId()); // Verify id

    }

    @Test
    @Order(3)

    public void test_getCountryByName()
    {
        country=new Country(2,"USA","Washington");
        String countryName="USA";
        when(countryService.getCountryByName(countryName)).thenReturn(country); // Mocking
        Country res = countryController.getCountryByName(countryName);
       // assertEquals(HttpStatus.FOUND,res.getStatusCode());
        assertEquals(countryName,res.getCountryName()); // Verify

    }
    @Test
    @Order(4)
    public void test_addCountry()
    {
        country=new Country(3,"Germany","Berlin");

        when(countryService.addCountry(country)).thenReturn(country);
        Country res = countryController.addCountry(country);
      //  assertEquals(HttpStatus.CREATED,res.getStatusCode());
        assertEquals(country,res);
    }
    @Test
    @Order(5)
    public void test_updateCountry()
    {
        country=new Country(3,"Japan","Tokyo");
        int countryID=3;
        when(countryService.getCountryByID(countryID)).thenReturn(country);// used when the method is returning
        when(countryService.updateCountry(country)).thenReturn(country);// used when the method is returning
        Country res=countryController.updateCountry(countryID,country);
      //  assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(3,res.getId());
        assertEquals("Japan",res.getCountryName());
        assertEquals("Tokyo",res.getCountryCapital());
    }

    @Test
    @Order(6)
    public void test_deleteCountry()
    {
        country=new Country(3,"Japan","Tokyo");
        int countryID=3;

        when(countryService.getCountryByID(countryID)).thenReturn(country);
            Country res=countryController.deleteCountry(countryID);
        assertEquals(countryID,res.getId());
    }
}
