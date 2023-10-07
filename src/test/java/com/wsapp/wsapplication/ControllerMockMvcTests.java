package com.wsapp.wsapplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsapp.wsapplication.controller.CountryController;
import com.wsapp.wsapplication.model.Country;
import com.wsapp.wsapplication.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(OrderAnnotation.class)
@ComponentScan(basePackages = "com.restservices.wsapplication")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = {ControllerMockMvcTests.class})
public class ControllerMockMvcTests {
    @Autowired
    MockMvc mockMvc;

    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    List<Country> myCountries;
    Country country;
    @BeforeEach
    public void setUp()
    {
        mockMvc= MockMvcBuilders.standaloneSetup(countryController).build();
    }
    @Test
    @Order(1)
    public  void test_getAllCountries() throws Exception
    {
        myCountries = new ArrayList<Country>();
        myCountries.add(new Country(1,"India","Delhi"));
        myCountries.add(new Country(2, "USA","Washington"));
        when(countryService.getAllCountries()).thenReturn(myCountries);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getcountries"))
                .andExpect(status().isFound())
                .andDo(print());
               // MockMvcRequestBuilders.get()
    }


    @Test
    @Order(2)
    public void test_getCountryByID() throws Exception
    {
        country=new Country(2, "USA", "Washington");
        int countryID=2;
        when(countryService.getCountryByID(countryID)).thenReturn(country);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getcountries/{id}",countryID))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("countryName").value("USA"))
                .andExpect(MockMvcResultMatchers.jsonPath("countryCapital").value("Washington"))
                .andDo(print());
    }
    @Test
    @Order(3)
    public void test_getCountryByName() throws Exception {
        country = new Country(2, "USA", "Washington");
        String countryName = "USA";
        when(countryService.getCountryByName(countryName)).thenReturn(country);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getcountries/countryname").param("name","USA"))
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("countryName").value("USA"))
                .andExpect(MockMvcResultMatchers.jsonPath("countryCapital").value("Washington"))
                .andDo(print());
    }

    @Test
    @Order(4)
    public void test_addCountry() throws Exception
    {
        country=new Country(3,"Germany", "Berlin");
        when(countryService.addCountry(country)).thenReturn(country);
        ObjectMapper mapper=new ObjectMapper();
        String jsonbody=mapper.writeValueAsString(country);

        this.mockMvc.perform(post("/addcountry")
                .content(jsonbody)
                .contentType(MediaType.APPLICATION_JSON)
                )
        .andExpect(status().isCreated())
            .andDo(print());
    }
    @Test
    @Order(5)
    public void test_updateCountry() throws Exception
    {
        country=new Country(3,"Japan", "Tokyo");
        int countryID = 3;

        when(countryService.getCountryByID(countryID)).thenReturn(country); // Mocking
        when(countryService.updateCountry(country)).thenReturn(country); // Mocking

        ObjectMapper mapper=new ObjectMapper();
        String jsonbody=mapper.writeValueAsString(country);

        this.mockMvc.perform(put("/updatecountry/{id}",countryID)
                .content(jsonbody)
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath(".countryName").value("Japan"))
                .andExpect(MockMvcResultMatchers.jsonPath(".countryCapital").value("Tokyo"))
                .andDo(print());
    }

    @Test
    @Order(6)
    public void test_deleteCpuntry() throws Exception
    {
        country=new Country(3, "Japan","Tokyo");
        int countryID=3;

        when(countryService.getCountryByID(countryID)).thenReturn(country);  // Mocking
        this.mockMvc.perform(delete("/deletecountry/{id}", countryID))
                .andExpect(status().isOk());
    }

}
