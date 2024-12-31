package com.example.salestax;

public class Item {
    private String description;
    private double price;
    private boolean isExempt;
    private boolean isImported;
    private int quantity;
    private double salesTax;

    public Item(String description, double price, int quantity, boolean isExempt, boolean isImported) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.isExempt = isExempt;
        this.isImported = isImported;
        this.salesTax = 0.0;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public boolean isImported() {
        return isImported;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getTotalPrice() {
        return (price + salesTax) * quantity;
    }
}
