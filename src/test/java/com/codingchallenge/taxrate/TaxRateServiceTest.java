package com.codingchallenge.taxrate;

import com.codingchallenge.item.model.BookItem;
import com.codingchallenge.item.model.Item;
import com.codingchallenge.item.model.OtherItem;
import com.codingchallenge.taxrate.service.TaxRateService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxRateServiceTest {

    private TaxRateService taxService = new TaxRateService();
    private Item firstItem = new BookItem("firstBook", 10, true);
    private Item secondItem = new OtherItem("otherItem", 10, true);

    @Test
    public void checkTaxRate() {
        ITaxRate taxRate = taxService.getTaxRate(firstItem);
        assertEquals(5, taxRate.getTaxRate());
        taxRate = taxService.getTaxRate(secondItem);
        assertEquals(15, taxRate.getTaxRate());
    }
}
