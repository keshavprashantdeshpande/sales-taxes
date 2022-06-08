package com.codingchallenge.item.model;

import com.codingchallenge.item.Exemption;
import com.codingchallenge.itemfactory.ItemFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Getter
@Setter
public abstract class Item {

    private String name;
    private double price;
    private boolean isImported;
    private Exemption exempted;

    public Item() {

    }

    public Item(String name, double price, boolean isImported, Exemption exempted) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.exempted = exempted;
    }

    public abstract ItemFactory getFactory();

}
