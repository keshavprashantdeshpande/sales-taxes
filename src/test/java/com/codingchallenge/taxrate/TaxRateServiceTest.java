package com.codingchallenge.taxrate;

import com.codingchallenge.item.model.*;
import com.codingchallenge.taxrate.service.TaxRateService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TaxRateServiceTest {

    private TaxRateService taxService = new TaxRateService();
    private Item firstItem = new BookItem("firstBook", 10, true);
    private Item secondItem = new OtherItem("otherItem", 10, true);
    private Item thirdItem = new MusicItem("thirdItem", 10, false);
    private Item fourthItem = new FoodItem("fourthItem", 10, false);

    @Test
    public void checkTaxRate() {
        ITaxRate taxRate = taxService.getTaxRate(firstItem);
        assertEquals(5, taxRate.getTaxRate());
        taxRate = taxService.getTaxRate(secondItem);
        assertEquals(15, taxRate.getTaxRate());
        taxRate = taxService.getTaxRate(thirdItem);
        assertEquals(10, taxRate.getTaxRate());
        taxRate = taxService.getTaxRate(fourthItem);
        assertNull(taxRate);
    }
}
