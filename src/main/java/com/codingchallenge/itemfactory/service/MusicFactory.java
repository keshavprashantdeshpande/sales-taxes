package com.codingchallenge.itemfactory.service;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.item.model.MusicItem;
import com.codingchallenge.itemfactory.ItemFactory;
import org.springframework.stereotype.Service;

@Service
public class MusicFactory implements ItemFactory {

    @Override
    public Item createProduct(String name, double price, boolean isImported) {
        return new MusicItem(name, price, isImported);
    }

}
