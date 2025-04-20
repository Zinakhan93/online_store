package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Product[] food = new Product[5];
    private int count = 0;

    public void addFood(Product product) {
        if (count < food.length) {
            food[count] = product;
            count++;
        } else {
            System.out.println(product.getName() + "-"+ " Невозможно добавить продукт в корзину ");
        }
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

   /* Данный метод неактуален, был актуален в 1 дз
   public void printBasketFood() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : food) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }
    */

    public boolean containsProduct(String name) {
        for (Product product : food) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true ;
            }
        }
        return false;
    }

    public void clearBasket() {
        food = new Product[5];
        count = 0;
    }
    public void printContents() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        for (int i = 0; i < count; i++) {
            System.out.println(food[i]);
            if (food[i].isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }




}
