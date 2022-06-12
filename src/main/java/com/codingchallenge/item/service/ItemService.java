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

    /**
     * Maps each line from the input file to the corresponding item in the shopping basket
     *
     * @param line Each line from the input file
     * @return Created basket item which contains item along with other data like quantity
     */
    public ShoppingBasketItem extractItems(String line) {
        ShoppingBasketItem item = null;
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

        item = new ShoppingBasketItem(product, quantity, taxService.getTaxRate(product));
        return item;
    }

    /**
     * It creates varioud types of items for us like book item, music item etc based on the name of the item
     *
     * @param price      Price of the item
     * @param name       Name of the item
     * @param isImported Whether the item is imported or not
     * @return Item created based on the name
     */
    public Item getItem(double price, String name, boolean isImported) {
        Item item = null;
        if (name.contains("book")) {
            item = FactoryProvider.getFactory("book").createProduct(name, price, isImported);
        } else if (name.contains("music")) {
            item = FactoryProvider.getFactory("music").createProduct(name, price, isImported);
        } else if (name.contains("chocolate")) {
            item = FactoryProvider.getFactory("food").createProduct(name, price, isImported);
        } else if (name.contains("pills")) {
            item = FactoryProvider.getFactory("medical").createProduct(name, price, isImported);
        } else {
            item = FactoryProvider.getFactory("other").createProduct(name, price, isImported);
        }
        return item;
    }
}
