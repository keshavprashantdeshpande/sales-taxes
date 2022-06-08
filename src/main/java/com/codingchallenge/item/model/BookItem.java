package com.codingchallenge.item.model;

import com.codingchallenge.item.service.ExemptedItem;
import com.codingchallenge.itemfactory.service.BookFactory;
import com.codingchallenge.itemfactory.ItemFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookItem extends Item {

    public BookItem() {

    }

    public BookItem(String name, double price, boolean isImported) {
        super(name, price, isImported, new ExemptedItem());
    }

    @Override
    public ItemFactory getFactory() {
        return new BookFactory();
    }
}
