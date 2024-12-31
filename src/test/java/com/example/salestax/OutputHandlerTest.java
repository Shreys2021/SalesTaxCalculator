package com.example.salestax;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class OutputHandlerTest {

    @Test
    public void testPrintReceipt() {

        List<Item> items = new ArrayList<>();
        items.add(new Item("book", 12.49, 1, false, true));
        items.add(new Item("imported bottle of perfume", 47.50, 1, true, false));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        OutputHandler.printReceipt(items, 7.65, 65.15);

        String expectedOutput = "Receipt:\n1 book: 12.49\n1 imported bottle of perfume: 47.50\nSales Taxes: 7.65\nTotal: 65.15\n";
        assertEquals(expectedOutput, baos.toString());
    }
}
