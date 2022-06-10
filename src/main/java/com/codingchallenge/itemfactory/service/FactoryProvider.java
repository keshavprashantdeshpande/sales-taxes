package com.codingchallenge.itemfactory.service;

import com.codingchallenge.itemfactory.ItemFactory;

public class FactoryProvider {

    public static ItemFactory getFactory(String productName) {
        if ("book".equals(productName)) {
            return new BookFactory();
        } else if ("music".equals(productName)) {
            return new MusicFactory();
        } else if ("food".equals(productName)) {
            return new FoodFactory();
        } else if ("medical".equals(productName)) {
            return new MedicalFactory();
        } else {
            return new OtherFactory();
        }
    }

}
