package com.codingchallenge.taxrate.service;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.taxrate.ITaxRate;
import org.springframework.stereotype.Service;

@Service
public class TaxRateService {

    public ITaxRate getTaxRate(Item product) {
        ITaxRate tax = null;
        if (!product.getExempted().isExempted()) {
            tax = new SaleTaxRate(10);
            if (product.isImported()) {
                tax = new ImportDuty(tax);
            }
        } else if (product.isImported()) {
            tax = new SaleTaxRate(0);
            tax = new ImportDuty(tax);
        }
        return tax;
    }
}
