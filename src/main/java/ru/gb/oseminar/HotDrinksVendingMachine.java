package ru.gb.oseminar;

import java.util.List;

public class HotDrinksVendingMachine implements VendingMachine{
    private final List<Product> products;

    public HotDrinksVendingMachine(List<Product> products) {
        this.products = products;
    }

    @Override
    public Product getProduct(String name){
        for(Product product: products){
            if(product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }

    public HotDrinks getProduct(String name, int volume, int temp){
        for(Product product: products){
            if(product instanceof HotDrinks){
                if(product.getName().equalsIgnoreCase(name) && ((HotDrinks) product).getVolume() == volume
                        && ((HotDrinks) product).getTemp() == temp){
                    return (HotDrinks) product;
                }
            }
        }
        throw new IllegalStateException(String.format("Продукт c названием %s не найден.", name));
    }
}
