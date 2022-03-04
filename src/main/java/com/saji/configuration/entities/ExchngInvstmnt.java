package com.saji.configuration.entities;

import javax.persistence.*;

@Entity
@Table(name = "EXCHANGE_INVESTMENT_CONFIG")
public class ExchngInvstmnt extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "EXCHANGE_ID", nullable = false)
    private Exchange exchange;
    @ManyToOne
    @JoinColumn(name = "INVESTMENT_ID", nullable = false)
    private Lov investment;
    @Column(name = "INVESTMENT_URL", nullable = false)
    private String invstmntUrl;
    @Column(name = "INVESTMENT_ROW", nullable = false)
    private Integer invstmntRow;
    @Column(name = "INVESTMENT_COL_START", nullable = false)
    private Integer invstmntColStrt;
    @Column(name = "INVESTMENT_COL_END", nullable = false)
    private Integer invstmntColEnd;
    @Column(name = "INVESTMENT_PATH", nullable = false)
    private String invstmntPath;

    public ExchngInvstmnt() {
    }

    public ExchngInvstmnt(Exchange exchange, Lov investment, String invstmntUrl, Integer invstmntRow, Integer invstmntColStrt, Integer invstmntColEnd, String invstmntPath) {
        this.exchange = exchange;
        this.investment = investment;
        this.invstmntUrl = invstmntUrl;
        this.invstmntRow = invstmntRow;
        this.invstmntColStrt = invstmntColStrt;
        this.invstmntColEnd = invstmntColEnd;
        this.invstmntPath = invstmntPath;
    }

    public String getInvstmntUrl() {
        return invstmntUrl;
    }

    public void setInvstmntUrl(final String invstmntUrl) {
        this.invstmntUrl = invstmntUrl;
    }

    public Integer getInvstmntRow() {
        return invstmntRow;
    }

    public void setInvstmntRow(final Integer invstmntRow) {
        this.invstmntRow = invstmntRow;
    }

    public Integer getInvstmntColStrt() {
        return invstmntColStrt;
    }

    public void setInvstmntColStrt(final Integer invstmntColStrt) {
        this.invstmntColStrt = invstmntColStrt;
    }

    public Integer getInvstmntColEnd() {
        return invstmntColEnd;
    }

    public void setInvstmntColEnd(final Integer invstmntColEnd) {
        this.invstmntColEnd = invstmntColEnd;
    }

    public String getInvstmntPath() {
        return invstmntPath;
    }

    public void setInvstmntPath(final String invstmntPath) {
        this.invstmntPath = invstmntPath;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(final Exchange exchange) {
        this.exchange = exchange;
    }

    public Lov getInvestment() {
        return investment;
    }

    public void setInvestment(final Lov investment) {
        this.investment = investment;
    }

}
