package com.codingchallenge.item;

import com.codingchallenge.item.model.BookItem;
import com.codingchallenge.item.model.Item;
import com.codingchallenge.item.service.ItemService;
import com.codingchallenge.order.model.ShoppingBasketItem;
import com.codingchallenge.taxrate.service.ImportDuty;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

    private String itemName = "2 box of imported chocolates at 11.25";

    @Autowired
    private ItemService service;

    @Test
    public void getItemTest() {
        Item item = service.getItem(10, "book item", true);
        assertTrue(item instanceof BookItem);
        assertEquals(10, item.getPrice());
        assertEquals("book item", item.getName());
        assertTrue(item.isImported());
    }

    @Test
    public void extractItemsTest() {
        ShoppingBasketItem item = service.extractItems(itemName);
        assertNotNull(item.getItem());
        assertEquals(2, item.getQuantity());
        assertTrue(item.getTaxRate() instanceof ImportDuty);
    }
}
