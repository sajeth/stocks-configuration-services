package com.saji.configuration.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "EXCHANGE")
public class Exchange extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country;
    @Column(name = "Y_REF")
    private String yRef;
    @Column(name = "HOME_PAGE")
    private String homePage;
    @Column(name = "BLOOMBERG_EXCHANGE_CODE")
    private String bloombergExchangeCode;
    @Column(name = "BLOOMBERG_COMPOSITE_CODE")
    private String bloomBergCompositeCode;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "GOOGLE_PREFIX")
    private String googlePrefix;
    @Column(name = "EOD_CODE")
    private String eodCode;

    @OneToMany(mappedBy = "exchange")
    private Set<ExchngInvstmnt> exchngInvstmnts;

    public Exchange() {
    }

    public Exchange(Country country, String yRef, String homePage, String bloombergExchangeCode, String bloomBergCompositeCode, String description, String googlePrefix, String eodCode) {
        this.country = country;
        this.yRef = yRef;
        this.homePage = homePage;
        this.bloombergExchangeCode = bloombergExchangeCode;
        this.bloomBergCompositeCode = bloomBergCompositeCode;
        this.description = description;
        this.googlePrefix = googlePrefix;
        this.eodCode = eodCode;
    }

    public String getyRef() {
        return yRef;
    }

    public void setyRef(final String yRef) {
        this.yRef = yRef;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(final String homePage) {
        this.homePage = homePage;
    }

    public String getBloombergExchangeCode() {
        return bloombergExchangeCode;
    }

    public void setBloombergExchangeCode(final String bloombergExchangeCode) {
        this.bloombergExchangeCode = bloombergExchangeCode;
    }

    public String getBloomBergCompositeCode() {
        return bloomBergCompositeCode;
    }

    public void setBloomBergCompositeCode(final String bloomBergCompositeCode) {
        this.bloomBergCompositeCode = bloomBergCompositeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getGooglePrefix() {
        return googlePrefix;
    }

    public void setGooglePrefix(final String googlePrefix) {
        this.googlePrefix = googlePrefix;
    }

    public String getEodCode() {
        return eodCode;
    }

    public void setEodCode(final String eodCode) {
        this.eodCode = eodCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public Set<ExchngInvstmnt> getExchngInvstmnts() {
        return exchngInvstmnts;
    }

    public void setExchngInvstmnts(final Set<ExchngInvstmnt> exchngInvstmnts) {
        this.exchngInvstmnts = exchngInvstmnts;
    }
}

