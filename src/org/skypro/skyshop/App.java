package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        System.out.println("App.main");
        ProductBasket basket= new ProductBasket();


        // Добавляем продуктов в корзину
        System.out.println("Добавление продукта в корзину.");
        Product apple = new Product("Яблоко", 200);
        Product bread = new Product("Бородинский", 120);
        Product orange = new Product("Апельсин", 200);
        Product kiwi = new Product("Киви", 250);
        Product mango = new Product("Манго", 300);
        Product grape = new Product("Виноград", 350);// Этот продукт не поместится в корзину


        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addFood(apple);
        basket.addFood(bread);
        basket.addFood(orange);
        basket.addFood(kiwi);
        basket.addFood(mango);
        basket.addFood(grape);

        // Печать содержимого корзины
        basket.printBasketFood();

        // Получение стоимости корзины c несколькими товарами
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко в корзине? " + basket.containsProduct("ЯБЛОКО"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли виноград в корзине? " + basket.containsProduct("Виноград"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        basket.printBasketFood();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());

        // Поиск товара по имени в пустой корзине
        System.out.println("Содержит ли пустая корзина яблоко? " + basket.containsProduct("Яблоко"));





















    }
}

