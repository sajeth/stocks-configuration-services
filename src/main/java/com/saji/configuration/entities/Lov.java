package com.saji.configuration.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOV")
public class Lov extends BaseEntity {

    @Column(name = "TYPE")
    private String type;


    public Lov() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

