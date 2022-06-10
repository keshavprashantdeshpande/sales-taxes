package com.codingchallenge.item.model;

import com.codingchallenge.item.service.NonExemptedItem;
import com.codingchallenge.itemfactory.ItemFactory;
import com.codingchallenge.itemfactory.service.OtherFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OtherItem extends Item {

    public OtherItem() {

    }

    public OtherItem(String name, double price, boolean isImported) {
        super(name, price, isImported, new NonExemptedItem());
    }

    @Override
    public ItemFactory getFactory() {
        return new OtherFactory();
    }

}
