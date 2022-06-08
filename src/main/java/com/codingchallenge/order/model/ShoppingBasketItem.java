package com.codingchallenge.order.model;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.taxrate.ITaxRate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Getter
@Setter
public class ShoppingBasketItem {

    private Item item;
    private int quantity;
    private double priceAfterTax;
    private ITaxRate taxRate;

    public ShoppingBasketItem(Item item, ITaxRate taxRate) {
        this.item = item;
        this.taxRate = taxRate;
    }

}
