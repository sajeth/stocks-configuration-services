package com.saji.configuration.services;

import com.saji.configuration.entities.ExchngInvstmnt;
import com.saji.configuration.repository.ExchngInvstmntRepository;
import com.saji.constants.LogicalDelIn;
import com.saji.pojos.configurations.ExchngInvstmntPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ExchngInvestmntService {
    @Autowired
    ExchngInvstmntRepository exchngInvstmntRepository;


    public void addExchngInvstmnt(ExchngInvstmntPojo exchngInvstmntPojo) {
        typeCast(new ExchngInvstmnt(), exchngInvstmntPojo);

    }

    public void updateExchngInvstmnt(ExchngInvstmntPojo exchngInvstmntPojo, BigInteger id) {
        exchngInvstmntRepository.findById(id).ifPresent(exchngInvstmnt -> typeCast(exchngInvstmnt, exchngInvstmntPojo));
    }


    public List<ExchngInvstmntPojo> findExchngInvestmntByExchange(BigInteger exchangeId) {
        return exchngInvstmntRepository.getInvestment(exchangeId).stream().map(this::typeCast).toList();

    }

    public ExchngInvstmntPojo findExchngInvestmntByExchange(BigInteger exchangeId, BigInteger lovid) {
        return typeCast(exchngInvstmntRepository.getInvestment(exchangeId, lovid));

    }

    public void deleteExchngInvstmnt(BigInteger id) {

        exchngInvstmntRepository.findById(id).ifPresent(val ->
            exchngInvstmntRepository.delete(val));
    }

    public List<ExchngInvstmntPojo> listExchngInvestmnt() {
        return exchngInvstmntRepository.findAll().stream().map(this::typeCast).toList();
    }

    private void typeCast(ExchngInvstmnt exchngInvstmnt, ExchngInvstmntPojo exchngInvstmntPojo) {

        exchngInvstmnt.setInvstmntColEnd(exchngInvstmntPojo.getInvstmntColEnd());
        exchngInvstmnt.setInvstmntColStrt(exchngInvstmntPojo.getInvstmntColEnd());
        exchngInvstmnt.setInvstmntPath(exchngInvstmntPojo.getInvstmntPath());
        exchngInvstmnt.setInvstmntRow(exchngInvstmntPojo.getInvstmntRow());
        exchngInvstmnt.setInvstmntUrl(exchngInvstmntPojo.getInvstmntUrl());
        exchngInvstmnt.setLogicalDelIn(exchngInvstmntPojo.getLogicalDelIn());
        exchngInvstmnt.setName(exchngInvstmntPojo.getName());
        exchngInvstmnt.setLogicalDelIn(LogicalDelIn.N.label);
        exchngInvstmntRepository.saveAndFlush(exchngInvstmnt);
    }

    private ExchngInvstmntPojo typeCast(ExchngInvstmnt exchngInvstmnt) {
        ExchngInvstmntPojo exchngInvstmntPojo = new ExchngInvstmntPojo();
        exchngInvstmntPojo.setInvstmntColEnd(exchngInvstmnt.getInvstmntColEnd());
        exchngInvstmntPojo.setInvstmntColStrt(exchngInvstmnt.getInvstmntColEnd());
        exchngInvstmntPojo.setInvstmntPath(exchngInvstmnt.getInvstmntPath());
        exchngInvstmntPojo.setInvstmntRow(exchngInvstmnt.getInvstmntRow());
        exchngInvstmntPojo.setInvstmntUrl(exchngInvstmnt.getInvstmntUrl());
        exchngInvstmntPojo.setLogicalDelIn(exchngInvstmnt.getLogicalDelIn());
        exchngInvstmntPojo.setName(exchngInvstmnt.getName());
        exchngInvstmntPojo.setCreatedBy(exchngInvstmnt.getCreatedBy());
        exchngInvstmntPojo.setCreatedDate(exchngInvstmnt.getCreatedDate());
        exchngInvstmntPojo.setModifiedDate(exchngInvstmnt.getModifiedDate());
        exchngInvstmntPojo.setId(exchngInvstmnt.getId());
        return exchngInvstmntPojo;
    }
}
