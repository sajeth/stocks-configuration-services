package com.saji.configuration.entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

/**
 * @author saji
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private BigInteger id;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CREATED_BY")
    private BigInteger createdBy;

    @Basic(optional = false)
    @Column(name = "CREATED_DT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "MODIFIED_BY")
    private BigInteger modifiedBy;

    @Column(name = "MODIFIED_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "LOGICAL_DEL_IN")
    private String logicalDeleteIn;


    public String getLogicalDelIn() {
        return logicalDeleteIn;
    }

    public void setLogicalDelIn(final String value) {
        this.logicalDeleteIn = value;
    }

    public BigInteger getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(final BigInteger value) {
        this.createdBy = value;
    }

    public Date getCreatedDate() {
        return Optional.ofNullable(this.createdDate).orElse(new Date());
    }

    public void setCreatedDate(final Date value) {
        this.createdDate = Optional.ofNullable(value).orElse(new Date());
    }

    public BigInteger getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(final BigInteger value) {
        this.modifiedBy = value;
    }

    public Date getModifiedDate() {
        return Optional.ofNullable(this.modifiedDate).orElse(new Date());
    }

    public void setModifiedDate(final Date value) {
        this.modifiedDate = Optional.ofNullable(value).orElse(new Date());
    }

    @PrePersist
    public void setNewDate() {
        this.setCreatedDate(new Date());
        this.setLogicalDelIn("N");
        this.setCreatedBy(BigInteger.valueOf(1L));
    }

    @PreUpdate
    public void setUpdatedDate() {
        this.setModifiedDate(new Date());
        this.setModifiedBy(BigInteger.valueOf(1L));
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(final BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
