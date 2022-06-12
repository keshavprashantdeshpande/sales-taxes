package com.codingchallenge.file.writer;

import com.codingchallenge.order.model.ShoppingBasket;
import com.codingchallenge.order.model.ShoppingBasketItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Writes the content of the receipt on the console
 */
@Service
@Slf4j
public class ConsoleWriterService {

    /**
     * @param basket Shopping basket of which we want to print the details
     */
    public void printReceipt(ShoppingBasket basket) {
        for (ShoppingBasketItem item : basket.getBasketItems()) {
            log.info(item.toString());
        }
        log.info("Sales Taxes: " + basket.getTotalSalesTax());
        log.info("Total: " + basket.getTotalPrice());
    }

}
