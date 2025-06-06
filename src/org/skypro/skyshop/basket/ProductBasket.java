package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    private Map<String, List<Product>> productsMap= new HashMap<>();

    public void addProduct(Product product) {
        List<Product> products = productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>());
        products.add(product);
    }


    public int getTotalPrice() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }
    public long countSpecialProducts() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();

    }
    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;

        }
        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + countSpecialProducts());
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void cleaningTheBasket() {
        productsMap.clear();
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }


}
