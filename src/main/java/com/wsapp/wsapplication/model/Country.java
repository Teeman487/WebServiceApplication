package com.wsapp.wsapplication.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="country_name", nullable = false)
    @Size(min=5,max=8,message="Provide at least 5 character " )
    String countryName;
    @Column(name="country_capital", nullable = false)
    String countryCapital;
   }
