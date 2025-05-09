package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    private final List<Product> food = new LinkedList<>();

    public void addFood(Product product) {
        food.add(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : food) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }
    public int countSpecialProducts() {
        int count = 0;
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

    public boolean containsProduct(String name) {
        for (Product product : food) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true ;
            }
        }
        return false;
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




}
