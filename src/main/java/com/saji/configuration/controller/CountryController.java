package com.saji.configuration.controller;

import com.saji.configuration.services.CountryService;
import com.saji.pojos.configurations.CountryPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/list")
    public @ResponseBody
    List<CountryPojo> getCountries() {
        return countryService.listCountries();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    CountryPojo getCountry(@PathVariable BigInteger id) {
        return countryService.findCountry(id);
    }

    @PostMapping("/new")
    public @ResponseBody
    void createNewCountry(@RequestBody CountryPojo pojo) {
        countryService.addCountry(pojo);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    void updateNewCountry(@PathVariable BigInteger id, @RequestBody CountryPojo pojo) {
        countryService.updateCountry(pojo, id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteCountry(@PathVariable BigInteger id) {
        countryService.deleteCountry(id);
    }
}
