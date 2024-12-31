package com.example.salestax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);
    private static final double MAX_PRICE = 10000.00;
    private static final int MAX_QUANTITY = 1000;

    public static List<Item> getItemsFromUser() {
        List<Item> items = new ArrayList<>();

        int numItems = getValidatedInteger("Enter the number of items:");

        for (int i = 0; i < numItems; i++) {
            System.out.println("Enter details for item " + (i + 1) + ":");

            String description = getValidatedDescription("Description (e.g., 'book', 'music CD'):");

            double price = getValidatedDouble("Price (e.g., 12.49, max " + MAX_PRICE + "):", MAX_PRICE);

            int quantity = getValidatedInteger("Quantity (e.g., 1, max " + MAX_QUANTITY + "):", MAX_QUANTITY);

            boolean isImported = getValidatedBoolean("Is the item imported? (yes/no):");

            boolean isExempt = getValidatedBoolean("Is the item exempt from sales tax? (yes/no):");

            Item item = new Item(description, price, quantity, isImported, isExempt);
            items.add(item);
        }

        return items;
    }

    private static int getValidatedInteger(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive integer:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
            }
        }
    }

    private static int getValidatedInteger(String prompt, int max) {
        while (true) {
            int value = getValidatedInteger(prompt);
            if (value <= max) {
                return value;
            } else {
                System.out.println("Value exceeds the maximum limit (" + max + "). Please enter a smaller number:");
            }
        }
    }

    private static double getValidatedDouble(String prompt, double max) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = scanner.nextLine().trim();
                double value = Double.parseDouble(input);
                if (value > 0 && value <= max) {
                    return value;
                } else if (value > max) {
                    System.out.println("Value exceeds the maximum limit (" + max + "). Please enter a smaller number:");
                } else {
                    System.out.println("Please enter a positive number:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
    }

    private static boolean getValidatedBoolean(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no':");
            }
        }
    }

    private static String getValidatedDescription(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (input.matches("^[a-zA-Z0-9].*") && !input.matches("^\\d+$")) {
                return input;
            } else {
                System.out.println(
                        "Invalid description. It must start with an alphanumeric character and cannot be purely numeric:");
            }
        }
    }
}
