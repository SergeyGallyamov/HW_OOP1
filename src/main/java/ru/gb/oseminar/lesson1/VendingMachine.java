package ru.gb.oseminar.lesson1;

public interface VendingMachine {
    Product getProduct(String name) throws IllegalStateException;
}
