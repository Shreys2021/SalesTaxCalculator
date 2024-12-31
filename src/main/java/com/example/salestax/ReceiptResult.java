package com.example.salestax;

import java.util.List;

public class ReceiptResult {
    private final List<Item> items;
    private final double totalTaxes;
    private final double totalCost;

    public ReceiptResult(List<Item> items, double totalTaxes, double totalCost) {
        this.items = items;
        this.totalTaxes = totalTaxes;
        this.totalCost = totalCost;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
