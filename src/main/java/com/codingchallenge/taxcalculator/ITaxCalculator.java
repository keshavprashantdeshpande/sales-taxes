package com.codingchallenge.taxcalculator;

import com.codingchallenge.order.model.ShoppingBasket;

public interface ITaxCalculator {

    double calculateTax(ShoppingBasket shoppingBasket);

}
