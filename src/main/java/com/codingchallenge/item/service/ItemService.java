package com.codingchallenge.item.service;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.itemfactory.service.FactoryProvider;
import com.codingchallenge.order.model.ShoppingBasketItem;
import com.codingchallenge.taxrate.service.TaxRateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemService {

    private static final String ITEM_SEPARATOR = " ";

    @Autowired
    private TaxRateService taxService;

    public ShoppingBasketItem extractItems(String line) {
        ShoppingBasketItem items = null;
        Item product = null;
        String[] itemsDetails = line.split(ITEM_SEPARATOR);
        double price = 0;
        int quantity = 0;
        boolean isImported;
        try {
            price = Double.valueOf(itemsDetails[itemsDetails.length - 1]);
            quantity = Integer.valueOf(itemsDetails[0]);
        } catch (NumberFormatException ex) {
            log.error("There was error parsing the input", ex);
        }
        isImported = line.contains("imported");
        itemsDetails = ArrayUtils.remove(itemsDetails, itemsDetails.length - 1);
        itemsDetails = ArrayUtils.remove(itemsDetails, itemsDetails.length - 1);
        itemsDetails = ArrayUtils.removeElement(itemsDetails, "imported");
        itemsDetails = ArrayUtils.remove(itemsDetails, 0);
        String name = ArrayUtils.toString(itemsDetails);
        product = getItem(price, name, isImported);

        items = new ShoppingBasketItem(product, quantity, taxService.getTaxRate(product));
        return items;
    }

    public Item getItem(double price, String name, boolean isImported) {
        Item product = null;
        if (name.contains("book")) {
            product = FactoryProvider.getFactory("book").createProduct(name, price, isImported);
        } else if (name.contains("music")) {
            product = FactoryProvider.getFactory("music").createProduct(name, price, isImported);
        } else if (name.contains("chocolate")) {
            product = FactoryProvider.getFactory("food").createProduct(name, price, isImported);
        } else if (name.contains("pills")) {
            product = FactoryProvider.getFactory("medical").createProduct(name, price, isImported);
        } else {
            product = FactoryProvider.getFactory("other").createProduct(name, price, isImported);
        }
        return product;
    }
}
