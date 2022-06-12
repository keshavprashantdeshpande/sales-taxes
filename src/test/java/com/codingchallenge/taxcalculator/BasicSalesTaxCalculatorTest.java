package com.codingchallenge.taxcalculator;

import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.service.ShoppingBasketService;
import com.codingchallenge.taxcalculator.service.BasicSalesTaxCalculator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicSalesTaxCalculatorTest {

    @Autowired
    private ShoppingBasketService service;

    private ITaxCalculator taxCalculator = new BasicSalesTaxCalculator();

    private String[] itemLines = {"1 imported box of chocolate at 10.00", "1 imported bottle of perfume at 47.50"};

    @Test
    public void testTaxCalculation() {
        service.getBasket().clearBasket();
        ShoppingBasket basket = service.createShoppingBasket(itemLines);
        assertEquals(7.65, taxCalculator.calculateTax(basket));
    }
}
