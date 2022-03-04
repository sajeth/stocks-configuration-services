package com.saji.configuration.services;

import com.saji.configuration.entities.Country;
import com.saji.configuration.entities.Exchange;
import com.saji.configuration.repository.CountryRepository;
import com.saji.constants.LogicalDelIn;
import com.saji.pojos.configurations.CountryPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ExchangeService exchangeService;

    public void addCountry(CountryPojo countryPojo) {
        typeCast(new Country(), countryPojo);
    }

    public void updateCountry(CountryPojo countryPojo, BigInteger id) {
        countryRepository.findById(id).ifPresent(country -> typeCast(country, countryPojo));
    }

    public CountryPojo findCountry(BigInteger countryId) {
        Optional<Country> country = countryRepository.findById(countryId);
        CountryPojo pojo = new CountryPojo();
        country.ifPresent(val ->
                typeCast(pojo, val));
        return pojo;
    }

    public void deleteCountry(BigInteger countryId) {

        countryRepository.findById(countryId).ifPresent(val -> {
            Iterator<Exchange> exchangeIterator = val.getExchanges().iterator();
            while (exchangeIterator.hasNext()) {
                exchangeService.deleteExchange(exchangeIterator.next().getId());
            }
            countryRepository.delete(val);
        });
    }

    public List<CountryPojo> listCountries() {
        return countryRepository.findAll().stream().map(val -> {
            CountryPojo countryPojo = new CountryPojo();
            typeCast(countryPojo, val);
            return countryPojo;
        }).toList();
    }

    private void typeCast(Country country, CountryPojo countryPojo) {

        country.setCountryCode(countryPojo.getCountryCode());
        country.setCurrency(countryPojo.getCurrency());
        country.setLogicalDelIn(LogicalDelIn.N.label);
        country.setName(countryPojo.getName());
        countryRepository.saveAndFlush(country);
    }

    private void typeCast(CountryPojo countryPojo, Country country) {

        countryPojo.setCountryCode(country.getCountryCode());
        countryPojo.setCurrency(country.getCurrency());
        countryPojo.setLogicalDelIn(country.getLogicalDelIn());
        countryPojo.setName(country.getName());
        countryPojo.setCreatedDate(country.getCreatedDate());
        countryPojo.setModifiedDate(country.getModifiedDate());
        countryPojo.setId(country.getId());
    }
}
