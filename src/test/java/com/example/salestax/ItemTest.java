package com.example.salestax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testItemInitialization() {
        Item item = new Item("book", 12.49, 1, false, true);

        assertEquals("book", item.getName());
        assertEquals(12.49, item.getPrice(), 0.01);
        assertEquals(1, item.getQuantity());
        assertEquals(false, item.isImported());
        assertEquals(true, item.isExempt());
    }
}
