package com.codingchallenge.taxrate.service;

import com.codingchallenge.taxrate.ITaxRate;

public abstract class AdditionalDuty implements ITaxRate {

    public ITaxRate taxRate;

    public AdditionalDuty(ITaxRate taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return taxRate.getTaxRate();
    }

}
