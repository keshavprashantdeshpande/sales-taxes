package com.codingchallenge.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@Getter
@Setter
public class ShoppingBasket {

    private List<ShoppingBasketItem> basketItems = new ArrayList<ShoppingBasketItem>();
    private double totalPrice = 0;
    private double totalSalesTax = 0;

    public void addShoppingItem(ShoppingBasketItem basketItem) {
        this.basketItems.add(basketItem);
    }

    public void clearBasket() {
        this.basketItems.removeAll(basketItems);
        this.totalPrice = 0;
        this.totalSalesTax = 0;
    }

    public void calculateTotalPrice() {
        for (ShoppingBasketItem item : this.getBasketItems()) {
            this.totalPrice = new BigDecimal(this.totalPrice + item.getPriceAfterTax()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }
}
