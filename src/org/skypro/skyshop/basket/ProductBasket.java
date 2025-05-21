package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

 hw-6
import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> productsMap= new HashMap<>();

    public void addProduct(Product product) {
        List<Product> products = productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>());
        products.add(product);

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    private final List<Product> food = new LinkedList<>();

    public void addFood(Product product) {
        food.add(product);
 master
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
 hw-6
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

        for (Product product : food) {
            if (product != null && product.isSpecial()) {
                count++;
            }
        }
        return count;
    }
    public void printBasket() {
        boolean isEmpty = true;
        for (Product product : food) {
            if (product != null) {
                System.out.println(product);
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + countSpecialProducts());
        }
    }

master
    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }
 hw-6
    public void cleaningTheBasket() {
        productsMap.clear();
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }





    public void cleaningTheBasket() {
        food.clear();
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = food.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }
 master




}
