package com.codingchallenge.item.model;

import com.codingchallenge.item.service.NonExemptedItem;
import com.codingchallenge.itemfactory.ItemFactory;
import com.codingchallenge.itemfactory.service.MusicFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MusicItem extends Item {

    public MusicItem() {

    }

    public MusicItem(String name, double price, boolean isImported) {
        super(name, price, isImported, new NonExemptedItem());
    }

    @Override
    public ItemFactory getFactory() {
        return new MusicFactory();
    }

}
