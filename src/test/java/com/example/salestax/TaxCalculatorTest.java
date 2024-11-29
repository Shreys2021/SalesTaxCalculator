package com.example.salestax;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void testCalculateSalesTaxForExemptItem() {
        Item item = new Item("book", 12.49, 1, false, true);
        double tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(0.0, tax, 0.01);
    }

    @Test
    public void testCalculateSalesTaxForNonExemptItem() {
        Item item = new Item("music CD", 14.99, 1, false, false);
        double tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(1.50, tax, 0.01);
    }

    @Test
    public void testCalculateSalesTaxForImportedExemptItem() {
        Item item = new Item("imported box of chocolates", 10.00, 1, true, true);
        double tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(0.50, tax, 0.01);
    }

    @Test
    public void testCalculateSalesTaxForImportedNonExemptItem() {
        Item item = new Item("imported bottle of perfume", 47.50, 1, true, false); // Imported non-exempt item
        double tax = TaxCalculator.calculateSalesTax(item);
        assertEquals(7.15, tax, 0.01);
    }
}
