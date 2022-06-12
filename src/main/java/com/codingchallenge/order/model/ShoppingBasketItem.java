package com.codingchallenge.order.model;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.taxrate.ITaxRate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class ShoppingBasketItem {

    private Item item;
    private int quantity;
    private double priceAfterTax;
    private ITaxRate taxRate;

    public ShoppingBasketItem(Item item, int quantity, ITaxRate taxRate) {
        this.item = item;
        this.quantity = quantity;
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        String imported = item.isImported() ? " imported " : " ";
        return quantity + imported + item.getName() + ": " + priceAfterTax;
    }
}
