package com.codingchallenge.itemfactory.service;

import com.codingchallenge.itemfactory.ItemFactory;

/**
 * Helper class to provide various kinds of factories based on the item name
 */
public class FactoryProvider {

    /**
     * @param itemName Name of the item
     * @return Type of factory based on the item name
     */
    public static ItemFactory getFactory(String itemName) {
        if ("book".equals(itemName)) {
            return new BookFactory();
        } else if ("music".equals(itemName)) {
            return new MusicFactory();
        } else if ("food".equals(itemName)) {
            return new FoodFactory();
        } else if ("medical".equals(itemName)) {
            return new MedicalFactory();
        } else {
            return new OtherFactory();
        }
    }

}
