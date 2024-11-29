package com.example.salestax;

public class TaxCalculator {
    public static double calculateSalesTax(Item item) {
        double taxRate = 0.0;

        if (!item.isExempt()) {
            taxRate += 0.10;
        }

        if (item.isImported()) {
            taxRate += 0.05;
        }

        double tax = item.getPrice() * taxRate;
        return roundToNearestFiveCents(tax);
    }

    private static double roundToNearestFiveCents(double value) {
        return Math.ceil(value * 20.0) / 20.0;
    }
}
