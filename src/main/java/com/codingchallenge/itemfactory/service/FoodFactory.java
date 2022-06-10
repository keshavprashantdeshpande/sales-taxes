package com.codingchallenge.itemfactory.service;

import com.codingchallenge.item.model.FoodItem;
import com.codingchallenge.item.model.Item;
import com.codingchallenge.itemfactory.ItemFactory;
import org.springframework.stereotype.Service;

@Service
public class FoodFactory implements ItemFactory {

    @Override
    public Item createProduct(String name, double price, boolean isImported) {
        return new FoodItem(name, price, isImported);
    }

}
