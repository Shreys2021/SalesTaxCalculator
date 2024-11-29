package com.example.salestax;

import java.util.List;

public class Receipt {
    private List<Item> items;
    private double salesTaxes;
    private double total;

    public Receipt(List<Item> items) {
        this.items = items;
        this.salesTaxes = 0.0;
        this.total = 0.0;
    }

    public void generateReceipt() {
        for (Item item : items) {
            double tax = TaxCalculator.calculateSalesTax(item);
            double itemTotal = item.getPrice() + tax;
            salesTaxes += tax;
            total += itemTotal;

            System.out.println(item.getQuantity() + " " + (item.isImported() ? "imported " : "") + item.getName() + ": "
                    + String.format("%.2f", itemTotal));
        }
        System.out.println("Sales Taxes: " + String.format("%.2f", salesTaxes));
        System.out.println("Total: " + String.format("%.2f", total));
    }

    public double getSalesTaxes() {
        return salesTaxes;
    }

    public double getTotal() {
        return total;
    }
}
