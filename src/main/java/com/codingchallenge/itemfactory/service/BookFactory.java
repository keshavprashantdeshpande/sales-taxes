package com.codingchallenge.itemfactory.service;

import com.codingchallenge.item.model.BookItem;
import com.codingchallenge.item.model.Item;
import com.codingchallenge.itemfactory.ItemFactory;
import org.springframework.stereotype.Service;

@Service
public class BookFactory implements ItemFactory {

    @Override
    public Item createProduct(String name, double price, boolean isImported) {
        return new BookItem(name, price, isImported);
    }

}
