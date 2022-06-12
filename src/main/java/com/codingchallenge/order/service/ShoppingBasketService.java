package com.codingchallenge.order.service;

import com.codingchallenge.file.reader.exception.WrongInputFormatException;
import com.codingchallenge.file.reader.service.FileReaderService;
import com.codingchallenge.file.writer.ConsoleWriterService;
import com.codingchallenge.item.service.ItemService;
import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.model.ShoppingBasketItem;
import com.codingchallenge.taxcalculator.ITaxCalculator;
import com.codingchallenge.taxcalculator.service.BasicSalesTaxCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ShoppingBasketService {

    private ShoppingBasket basket;
    private ConsoleWriterService writer;
    private FileReaderService reader;
    private ItemService itemService;

    @Autowired
    public ShoppingBasketService(ShoppingBasket basket, ConsoleWriterService writer, FileReaderService reader, ItemService itemService) {
        this.basket = basket;
        this.writer = writer;
        this.reader = reader;
        this.itemService = itemService;
    }

    public void processOrder(String... args) throws IOException, WrongInputFormatException {
        for (String arg : args) {
            String[] itemLines = reader.readFile(arg);
            this.createShoppingBasket(itemLines);
            ITaxCalculator tax = new BasicSalesTaxCalculator();
            writer.printReceipt(basket, tax.calculateTax(basket));
            basket.clearBasket();
        }
    }

    public ShoppingBasket createShoppingBasket(String[] itemLines) {
        for (String productLine : itemLines) {
            ShoppingBasketItem item = itemService.extractItems(productLine);
            if (item != null) {
                basket.addShoppingItem(item);
            }
        }
        return this.basket;
    }
}
