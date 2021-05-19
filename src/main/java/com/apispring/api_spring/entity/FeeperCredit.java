package com.apispring.api_spring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fee_per_credit")
public class FeeperCredit {

    @Id
    @NonNull
    @Column(name = "Year")
    private int year;

    @Column (name = "Fee")
    private double fee;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public FeeperCredit(int year, double fee) {
        this.year = year;
        this.fee = fee;
    }

    public FeeperCredit() {
    }
}
