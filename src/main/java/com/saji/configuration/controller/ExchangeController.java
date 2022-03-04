package com.saji.configuration.controller;

import com.saji.configuration.services.ExchangeService;
import com.saji.pojos.configurations.ExchangePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/{id}")
    public @ResponseBody
    ExchangePojo getExchange(@PathVariable BigInteger id) {
        return exchangeService.findExchange(id);
    }

    @GetMapping("/country/{id}")
    public @ResponseBody
    List<ExchangePojo> getExchangeByCountry(@PathVariable BigInteger id) {
        return exchangeService.findExchangeByCountry(id);
    }

    @PostMapping("/new")
    public @ResponseBody
    void createNewExchange(@RequestBody ExchangePojo pojo) {
        exchangeService.addExchange(pojo);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    void updateNewexchange(@PathVariable BigInteger id, @RequestBody ExchangePojo pojo) {
        exchangeService.updateExchange(pojo, id);
    }
}
