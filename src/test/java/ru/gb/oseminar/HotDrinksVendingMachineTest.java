package ru.gb.oseminar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.oseminar.lesson1.HotDrinks;
import ru.gb.oseminar.lesson1.HotDrinksVendingMachine;
import ru.gb.oseminar.lesson1.Product;

import java.util.ArrayList;
import java.util.List;

public class HotDrinksVendingMachineTest {
    private List<Product> products;
    private HotDrinksVendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        this.vendingMachine = new HotDrinksVendingMachine(products);
    }

    @Test
    void getProductTestSuccessful() {
        // expected
        products.add(new HotDrinks("ExampleName1", 1.0d,90 ,1000));
        products.add(new HotDrinks("ExampleName2", 2.0d, 80,500));
        this.vendingMachine = new HotDrinksVendingMachine(products);
        HotDrinks expected = new HotDrinks("ExampleName2", 2.0d, 80,500);

        // actual
        HotDrinks actual = vendingMachine.getProduct("ExampleName2", 500,80);

        Assertions.assertEquals(expected, actual);
    }
}
