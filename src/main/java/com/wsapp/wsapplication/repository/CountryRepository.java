package com.wsapp.wsapplication.repository;

import com.wsapp.wsapplication.model.Country;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {  // create field in MySQL
}
