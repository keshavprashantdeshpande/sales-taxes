package com.codingchallenge.file.writer;

import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.model.ShoppingBasketItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Slf4j
public class ConsoleWriterService {

    public void printReceipt(ShoppingBasket basket, double tax) {
        double totalPrice = 0;
        for (ShoppingBasketItem item : basket.getBasketItems()) {
            String imported = item.getItem().isImported() ? " imported " : " ";
            totalPrice = new BigDecimal(totalPrice + item.getPriceAfterTax()).setScale(2, RoundingMode.HALF_UP).doubleValue();
            log.info(item.getQuantity() + imported + item.getItem().getName() + ": " + item.getPriceAfterTax());
        }
        log.info("Sales Taxes: " + tax);
        log.info("Total: " + totalPrice);
    }

}
