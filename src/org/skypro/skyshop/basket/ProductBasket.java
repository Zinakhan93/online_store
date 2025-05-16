package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> productsMap= new HashMap<>();

    public void addProduct(Product product) {
        List<Product> products = productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>());
        products.add(product);
    }


    public int getTotalPrice() {
        int totalPrice = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }
    public int countSpecialProducts() {
        int count = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }
    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;

        }
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product);
            }
        }

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
