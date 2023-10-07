/*
package com.wsapp.wsapplication.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Country {
    */
/*@Id
    @Column(name="id")*//*


    @NotNull(message="id must not be null")
    int id;
    */
/*@Column(name="countryName")*//*

    @NotNull(message="countryName must not be null")  // validation
    @Size(min=5,message="countryName must be at least 5 in size" ) // validation
    String countryName;
    */
/*@Column(name="countryCapital")*//*

    @NotNull(message="countryCapital must not be null")  // validation
    @Size(min=5,message="countryCapital must be at least 5 in size" ) // validation
    String countryCapital;

    public Country(int id, String countryName, String countryCapital) {
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
    }

    public Country() {}  // Default Constructor

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }
}
*/
