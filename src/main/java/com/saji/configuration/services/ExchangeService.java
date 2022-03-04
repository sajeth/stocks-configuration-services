package com.saji.configuration.services;

import com.saji.configuration.entities.Exchange;
import com.saji.configuration.entities.ExchngInvstmnt;
import com.saji.configuration.repository.ExchangeRepository;
import com.saji.constants.LogicalDelIn;
import com.saji.pojos.configurations.ExchangePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepository exchangeRepository;

    @Autowired
    ExchngInvestmntService exchngInvestmntService;

    public void addExchange(ExchangePojo exchangePojo) {
        typeCast(new Exchange(), exchangePojo);
    }

    public void updateExchange(ExchangePojo exchangePojo, BigInteger id) {
        exchangeRepository.findById(id).ifPresent(exchange -> typeCast(exchange, exchangePojo));
    }

    public ExchangePojo findExchange(BigInteger id) {
        Optional<Exchange> exchange = exchangeRepository.findById(id);
        exchange.ifPresent(val ->
                typeCast(val));
        if (exchange.isPresent()) {
            return typeCast(exchange.get());
        }
        return null;
    }

    public void deleteExchange(BigInteger exchangeId) {
        exchangeRepository.findById(exchangeId).ifPresent(val -> {
            Iterator<ExchngInvstmnt> exchngInvstmntIterator = val.getExchngInvstmnts().iterator();
            while (exchngInvstmntIterator.hasNext()) {
                exchngInvestmntService.deleteExchngInvstmnt(exchngInvstmntIterator.next().getId());
            }
            val.getExchngInvstmnts().iterator().forEachRemaining(exchngInvstmnt -> exchngInvestmntService.deleteExchngInvstmnt(exchngInvstmnt.getId()));
            exchangeRepository.delete(val);
        });
    }

    public List<ExchangePojo> listExchanges() {
        return exchangeRepository.findAll().stream().map(val -> typeCast(val)).toList();
    }

    private void typeCast(Exchange exchange, ExchangePojo exchangePojo) {

        exchange.setBloomBergCompositeCode(exchangePojo.getBloomBergCompositeCode());
        exchange.setBloombergExchangeCode(exchangePojo.getBloombergExchangeCode());
        exchange.setLogicalDelIn(LogicalDelIn.N.label);
        exchange.setDescription(exchangePojo.getDescription());
        exchange.setEodCode(exchangePojo.getEodCode());
        exchange.setGooglePrefix(exchangePojo.getGooglePrefix());
        exchange.setHomePage(exchangePojo.getHomePage());
        exchange.setyRef(exchangePojo.getyRef());
        exchange.setLogicalDelIn(exchangePojo.getLogicalDelIn());
        exchange.setName(exchangePojo.getName());
        exchange.setCreatedDate(exchangePojo.getCreatedDate());
        exchange.setModifiedDate(exchangePojo.getModifiedDate());
        exchangeRepository.saveAndFlush(exchange);
    }

    private ExchangePojo typeCast(Exchange exchange) {
        ExchangePojo exchangePojo = new ExchangePojo();
        exchangePojo.setBloomBergCompositeCode(exchange.getBloomBergCompositeCode());
        exchangePojo.setBloombergExchangeCode(exchange.getBloombergExchangeCode());
        exchangePojo.setDescription(exchange.getDescription());
        exchangePojo.setEodCode(exchange.getEodCode());
        exchangePojo.setGooglePrefix(exchange.getGooglePrefix());
        exchangePojo.setHomePage(exchange.getHomePage());
        exchangePojo.setyRef(exchange.getyRef());
        exchangePojo.setLogicalDelIn(exchange.getLogicalDelIn());
        exchangePojo.setName(exchange.getName());
        exchangePojo.setCreatedDate(exchange.getCreatedDate());
        exchangePojo.setModifiedDate(exchange.getModifiedDate());
        exchangePojo.setId(exchange.getId());
        return exchangePojo;
    }

    public List<ExchangePojo> findExchangeByCountry(BigInteger id) {

        return exchangeRepository.getExchangesByCountry(id).stream().map(val -> typeCast(val)).toList();
    }
}
