package com.example.salestax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void testItemInitialization() {
        Item item = new Item("book", 12.49, 1, false, true);

        assertEquals("book", item.getDescription());
        assertEquals(12.49, item.getPrice(), 0.01);
        assertEquals(1, item.getQuantity());
        assertEquals(false, item.isImported());
        assertEquals(true, item.isExempt());
    }

    @Test
    public void testSalesTaxCalculation() {
        Item importedPerfume = new Item("imported bottle of perfume", 47.50, 1, true, false);
        importedPerfume.setSalesTax(7.15);

        assertEquals(7.15, importedPerfume.getSalesTax(), 0.01);
        assertEquals(54.65, importedPerfume.getTotalPrice(), 0.01);
    }
}
