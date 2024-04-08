package com.wsapp.wsapplication.repository;

import com.wsapp.wsapplication.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
  //  Optional<Country> findByName(String countryName);
  }
