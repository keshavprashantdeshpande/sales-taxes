package com.codingchallenge.item.model;

import com.codingchallenge.item.service.ExemptedItem;
import com.codingchallenge.itemfactory.ItemFactory;
import com.codingchallenge.itemfactory.service.MedicalFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MedicalItem extends Item {

    public MedicalItem() {

    }

    public MedicalItem(String name, double price, boolean isImported) {
        super(name, price, isImported, new ExemptedItem());
    }

    @Override
    public ItemFactory getFactory() {
        return new MedicalFactory();
    }

}
