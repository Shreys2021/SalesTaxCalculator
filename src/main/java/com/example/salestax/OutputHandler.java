package com.example.salestax;

import java.util.List;

public class OutputHandler {

    public static void printReceipt(List<Item> items, double totalTaxes, double totalCost) {
        System.out.println("Receipt:");
        for (Item item : items) {
            String importedText = item.isImported() ? "imported " : "";
            System.out.printf("%d %s%s: %.2f%n", item.getQuantity(), importedText, item.getDescription(),
                    item.getTotalPrice());
        }
        System.out.printf("Sales Taxes: %.2f%n", totalTaxes);
        System.out.printf("Total: %.2f%n", totalCost);
    }
}
