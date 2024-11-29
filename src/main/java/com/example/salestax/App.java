package com.example.salestax;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        System.out.println("Input 2:");
        List<Item> input2 = new ArrayList<>();
        input2.add(new Item("imported box of chocolates", 10.00, 1, true, true));
        input2.add(new Item("imported bottle of perfume", 47.50, 1, true, false));
        Receipt receipt2 = new Receipt(input2);
        receipt2.generateReceipt();

        System.out.println();

        System.out.println("Input 3:");
        List<Item> input3 = new ArrayList<>();
        input3.add(new Item("imported bottle of perfume", 27.99, 1, true, false));
        input3.add(new Item("bottle of perfume", 18.99, 1, false, false));
        input3.add(new Item("packet of headache pills", 9.75, 1, false, true));
        input3.add(new Item("imported box of chocolates", 11.25, 1, true, true));
        Receipt receipt3 = new Receipt(input3);
        receipt3.generateReceipt();
    }
}
