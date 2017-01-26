/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ispit.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Mirai
 */
@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instrumentId")
    private Integer instrumentId;

    @Column(name = "instrumentName", length = 50, nullable = false)
    private String instrumentName;

    @Column(name = "instrumentPrice", nullable = false)
    private double instrumentPrice;

    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @ManyToOne(optional = false)
    private Category categoryId;

    public Instrument() {
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public double getInstrumentPrice() {
        return instrumentPrice;
    }

    public void setInstrumentPrice(double instrumentPrice) {
        this.instrumentPrice = instrumentPrice;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instrumentId != null ? instrumentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrument)) {
            return false;
        }
        Instrument other = (Instrument) object;
        if ((this.instrumentId == null && other.instrumentId != null) || (this.instrumentId != null && !this.instrumentId.equals(other.instrumentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return instrumentName;
    }

}
