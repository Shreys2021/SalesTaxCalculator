package com.example.salestax;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    @Test
    public void testReceiptForInput2() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("imported box of chocolates", 10.00, 1, true, true));
        items.add(new Item("imported bottle of perfume", 47.50, 1, true, false));

        Receipt receipt = new Receipt(items);
        receipt.generateReceipt();

        assertEquals(65.15, receipt.getTotal(), 0.01);
        assertEquals(7.65, receipt.getSalesTaxes(), 0.01);
    }

    @Test
    public void testReceiptForInput3() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("imported bottle of perfume", 27.99, 1, true, false));
        items.add(new Item("bottle of perfume", 18.99, 1, false, false));
        items.add(new Item("packet of headache pills", 9.75, 1, false, true));
        items.add(new Item("imported box of chocolates", 11.25, 1, true, true));

        Receipt receipt = new Receipt(items);
        receipt.generateReceipt();

        assertEquals(74.68, receipt.getTotal(), 0.01);
        assertEquals(6.70, receipt.getSalesTaxes(), 0.01);
    }
}
