package com.codingchallenge.order.service;

import com.codingchallenge.file.reader.exception.WrongInputFormatException;
import com.codingchallenge.file.reader.service.FileReaderService;
import com.codingchallenge.file.writer.ConsoleWriterService;
import com.codingchallenge.item.service.ItemService;
import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.model.ShoppingBasketItem;
import com.codingchallenge.taxcalculator.ITaxCalculator;
import com.codingchallenge.taxcalculator.service.BasicSalesTaxCalculator;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * This class is responsible for all the main operations like creating items from the input file, adding those items in the shopping cart,
 * creating and calculating tax
 */
@Service
@Slf4j
@Getter
@Setter
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

    /**
     * @param args
     * @throws IOException
     * @throws WrongInputFormatException
     */
    public void processOrder(String... args) throws IOException, WrongInputFormatException {
        for (String arg : args) {
            String[] itemLines = reader.readFile(arg);
            this.createShoppingBasket(itemLines);
            ITaxCalculator tax = new BasicSalesTaxCalculator();
            basket.setTotalSalesTax(tax.calculateTax(basket));
            basket.calculateTotalPrice();
            writer.printReceipt(basket);
            basket.clearBasket();
        }
    }

    /**
     * @param itemLines Represents each line from the input file seperated by newline
     * @return Shopping basket which contains all the items in it
     */
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
