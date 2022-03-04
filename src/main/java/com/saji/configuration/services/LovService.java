package com.saji.configuration.services;

import com.saji.configuration.entities.Lov;
import com.saji.configuration.repository.ExchngInvstmntRepository;
import com.saji.configuration.repository.LovRepository;
import com.saji.constants.LogicalDelIn;
import com.saji.pojos.common.LovPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class LovService {
    @Autowired
    LovRepository lovRepository;
    @Autowired
    ExchngInvstmntRepository exchngInvstmntRepository;

    public void addLov(LovPojo lovPojo) {
        Lov lov = new Lov();
        typeCast(lov, lovPojo);
        lovRepository.saveAndFlush(lov);
    }

    public void updateLov(LovPojo lovPojo, BigInteger id) {
        lovRepository.findById(id).ifPresent(lov -> {
            typeCast(lov, lovPojo);
            lovRepository.saveAndFlush(lov);
        });
    }

    public LovPojo findLov(BigInteger id) {
        Optional<Lov> lov = lovRepository.findById(id);
        LovPojo pojo = new LovPojo();
        lov.ifPresent(val ->
                typeCast(pojo, val));
        return pojo;
    }

    public void deleteLov(BigInteger id) {

        lovRepository.deleteLov(id);
    }

    public List<LovPojo> listLov() {
        return lovRepository.findAll().stream().map(val -> {
            LovPojo lovPojo = new LovPojo();
            typeCast(lovPojo, val);
            return lovPojo;
        }).toList();
    }

    private void typeCast(Lov lov, LovPojo lovPojo) {

        lov.setType(lov.getType());
        lov.setLogicalDelIn(LogicalDelIn.N.label);
        lov.setName(lovPojo.getName());
    }

    private void typeCast(LovPojo lovPojo, Lov lov) {

        lovPojo.setType(lov.getType());
        lovPojo.setLogicalDelIn(lov.getLogicalDelIn());
        lovPojo.setName(lov.getName());
        lovPojo.setCreatedDate(lov.getCreatedDate());
        lovPojo.setModifiedDate(lov.getModifiedDate());
        lovPojo.setId(lov.getId());
    }
}
