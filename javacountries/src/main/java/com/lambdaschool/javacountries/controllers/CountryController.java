package com.lambdaschool.javacountries.controllers;

import com.lambdaschool.javacountries.models.Country;
import com.lambdaschool.javacountries.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CountryController {
    @Autowired
    CountryRepository countrepos;

    // http://localhost:2019/countries/all
    @GetMapping(value = "/countries/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountries(){

        List<Country> myList = new ArrayList<>();
        countrepos.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
