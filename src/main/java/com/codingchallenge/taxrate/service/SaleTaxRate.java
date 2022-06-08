package com.codingchallenge.taxrate.service;

import com.codingchallenge.taxrate.ITaxRate;
import org.springframework.stereotype.Service;

@Service
public class SaleTaxRate implements ITaxRate {

    public double taxRate;

    public SaleTaxRate() {

    }

    public SaleTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public double getTaxRate() {
        return this.taxRate;
    }

}
