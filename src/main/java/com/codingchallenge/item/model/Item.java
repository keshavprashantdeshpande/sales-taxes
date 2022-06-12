package com.codingchallenge.item.model;

import com.codingchallenge.item.Exemption;
import com.codingchallenge.itemfactory.ItemFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Parent class which will hold any kind of item in it. Can be extended to create specific kind of items. Contains
 * general attributes associated with products as members
 */
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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isImported=" + isImported +
                ", exempted=" + exempted +
                '}';
    }
}
