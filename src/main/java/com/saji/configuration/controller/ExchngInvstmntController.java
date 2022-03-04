package com.saji.configuration.controller;

import com.saji.configuration.services.ExchngInvestmntService;
import com.saji.pojos.configurations.ExchngInvstmntPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/investment")
public class ExchngInvstmntController {

    @Autowired
    private ExchngInvestmntService exchngInvestmntService;

    @GetMapping("/list")
    public @ResponseBody
    List<ExchngInvstmntPojo> getExchngInvestmntList() {
        return exchngInvestmntService.listExchngInvestmnt();
    }

    @GetMapping("/exchange/{id}")
    public @ResponseBody
    List<ExchngInvstmntPojo> getExchngInvestmntByCountryExchange(@PathVariable BigInteger id) {
        return exchngInvestmntService.findExchngInvestmntByExchange(id);
    }

    @GetMapping("/exchange/{exchange}/lov/{lovid}")
    public @ResponseBody
    ExchngInvstmntPojo getExchngInvestmnt(@PathVariable BigInteger exchange, @PathVariable BigInteger lovid) {
        return exchngInvestmntService.findExchngInvestmntByExchange(exchange, lovid);
    }

    @PostMapping("/new")
    public @ResponseBody
    void createNewExchngInvestmnt(@RequestBody ExchngInvstmntPojo pojo) {
        exchngInvestmntService.addExchngInvstmnt(pojo);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    void updateExchngInvestmnt(@PathVariable BigInteger id, @RequestBody ExchngInvstmntPojo pojo) {
        exchngInvestmntService.updateExchngInvstmnt(pojo, id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteExchngInvestmnt(@PathVariable BigInteger id) {
        exchngInvestmntService.deleteExchngInvstmnt(id);
    }
}
