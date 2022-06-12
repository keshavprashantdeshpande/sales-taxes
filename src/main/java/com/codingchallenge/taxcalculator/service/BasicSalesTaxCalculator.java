package com.codingchallenge.taxcalculator.service;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.model.ShoppingBasketItem;
import com.codingchallenge.taxcalculator.ITaxCalculator;
import com.codingchallenge.util.math.MathHelper;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicSalesTaxCalculator implements ITaxCalculator {

    private double salesTax = 0;

    @Override
    public double calculateTax(ShoppingBasket shoppingBasket) {
        salesTax = 0;
        for (ShoppingBasketItem basketItem : shoppingBasket.getBasketItems()) {
            Item item = basketItem.getItem();
            if (!item.getExempted().isExempted() || item.isImported()) {
                double tax = MathHelper.roundOffValue((basketItem.getQuantity() * item.getPrice() * basketItem.getTaxRate().getTaxRate()) / 100);
                BigDecimal roundtax = new BigDecimal(item.getPrice() + tax).setScale(2, RoundingMode.HALF_UP);
                basketItem.setPriceAfterTax(roundtax.doubleValue());
                salesTax = new BigDecimal(salesTax + tax).setScale(2, RoundingMode.HALF_UP).doubleValue();
            } else {
                basketItem.setPriceAfterTax(item.getPrice());
            }
        }
        return this.salesTax;
    }
}
