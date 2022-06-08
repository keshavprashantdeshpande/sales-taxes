package com.codingchallenge.order.service;

import com.codingchallenge.item.model.Item;
import com.codingchallenge.itemfactory.service.FactoryProvider;
import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.model.ShoppingBasketItem;
import com.codingchallenge.taxcalculator.ITaxCalculator;
import com.codingchallenge.taxcalculator.service.BasicSalesTaxCalculator;
import com.codingchallenge.taxrate.ITaxRate;
import com.codingchallenge.taxrate.service.ImportDuty;
import com.codingchallenge.taxrate.service.SaleTaxRate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShoppingBasketService {

    private static final String ITEM_SEPARATOR = " ";

    @Autowired
    private ShoppingBasket basket;

    public void processOrder(String[] productLines) {

        for (String productLine : productLines) {
            ShoppingBasketItem item = extractItems(productLine);
            if (item != null) {
                basket.addShoppingItem(item);
            }
        }
        ITaxCalculator tax = new BasicSalesTaxCalculator();
        basket.clearBasket();
    }

    private ShoppingBasketItem extractItems(String line) {
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
        product = getProduct(price, name, isImported);

        items = new ShoppingBasketItem(product, quantity, getTaxRate(product));
        return items;
    }

    private Item getProduct(double price, String name, boolean isImported) {
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

    private ITaxRate getTaxRate(Item product) {
        ITaxRate tax = null;
        if (!product.getExempted().isExempted()) {
            tax = new SaleTaxRate(10);
            if (product.isImported()) {
                tax = new ImportDuty(tax);
            }
        } else if (product.isImported()) {
            tax = new SaleTaxRate(0);
            tax = new ImportDuty(tax);
        }
        return tax;
    }
}
