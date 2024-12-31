package com.example.salestax;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private final List<Item> items;

    public Receipt(List<Item> items) {
        this.items = items;
    }

    public ReceiptResult calculateReceipt() {
        double totalTaxes = 0.0;
        double totalCost = 0.0;

        for (Item item : items) {
            double salesTax = calculateSalesTax(item);
            item.setSalesTax(salesTax);
            totalTaxes += salesTax * item.getQuantity();
            totalCost += item.getTotalPrice();
        }

        return new ReceiptResult(items, totalTaxes, totalCost);
    }

    private double calculateSalesTax(Item item) {
        double basicTax = item.isExempt() ? 0.0 : roundUpToNearestFiveCents(item.getPrice() * 0.10);
        double importDuty = item.isImported() ? roundUpToNearestFiveCents(item.getPrice() * 0.05) : 0.0;
        return basicTax + importDuty;
    }

    private double roundUpToNearestFiveCents(double value) {
        return Math.ceil(value * 20.0) / 20.0;
    }
}
