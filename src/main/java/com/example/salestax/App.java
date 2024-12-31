package com.example.salestax;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Sales Tax Calculator!");

        List<Item> items = InputHandler.getItemsFromUser();

        Receipt receipt = new Receipt(items);
        ReceiptResult result = receipt.calculateReceipt();

        OutputHandler.printReceipt(result.getItems(), result.getTotalTaxes(), result.getTotalCost());
    }
}
