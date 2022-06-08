package com.codingchallenge.itemfactory;

import com.codingchallenge.item.model.Item;

public interface ItemFactory {

    Item createProduct(String name, double price, boolean isImported);

}
