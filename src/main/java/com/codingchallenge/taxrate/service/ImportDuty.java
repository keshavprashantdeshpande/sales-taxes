package com.codingchallenge.taxrate.service;

import com.codingchallenge.taxrate.ITaxRate;

public class ImportDuty extends AdditionalDuty {

    public double additionalTaxRate;

    public ImportDuty(ITaxRate taxRate) {
        super(taxRate);
        this.additionalTaxRate = 5;
    }

    @Override
    public double getTaxRate() {
        return taxRate.getTaxRate() + this.additionalTaxRate;
    }
}
