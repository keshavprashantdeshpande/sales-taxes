package com.codingchallenge.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@Getter
@Setter
public class ShoppingBasket {

    private List<ShoppingBasketItem> basketItems = new ArrayList<ShoppingBasketItem>();

    public void addShoppingItem(ShoppingBasketItem basketItem) {
        this.basketItems.add(basketItem);
    }

    public void clearBasket() {
        this.basketItems.removeAll(basketItems);
    }

}
