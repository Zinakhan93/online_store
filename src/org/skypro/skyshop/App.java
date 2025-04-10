package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        System.out.println("App.main");
        ProductBasket basket= new ProductBasket();
        ProductBasket basket2= new ProductBasket();
        ProductBasket basket3= new ProductBasket();


        // Добавляем продуктов в корзину

        Product apple = new Product("Яблоко", 200);
        Product bread = new Product("Бородинский", 120);
        Product orange = new Product("Апельсин", 200);
        Product kiwi = new Product("Киви", 250);
        Product mango = new Product("Манго", 300);
        Product grape = new Product("Виноград", 350);// Этот продукт не поместится в корзину
        Product chocolate =new Product("Шоколад",300);
        Product cheese = new Product("Сыр", 520);
        Product oil = new Product("Масло", 1200);


        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addFood(apple);
        basket.addFood(bread);
        basket.addFood(orange);
        basket.addFood(kiwi);
        basket.addFood(mango);
        basket.addFood(grape);

        // Добавляем во вторую корзину товары
        basket2.addFood(chocolate);
        basket2.addFood(cheese);
        basket2.addFood(oil);
        basket2.addFood(grape);


        // Печать содержимого корзины
        System.out.println("Содержимое корзины №1");
        basket.printBasketFood();

        System.out.println("Содержимое корзины №2");
        basket2.printBasketFood();
        System.out.println("Содержимое корзины №3");
        basket3.printBasketFood();


        // Получение стоимости корзины c несколькими товарами
        System.out.println("Общая стоимость корзины 1: " + basket.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко в корзине 1? " + basket.containsProduct("ЯБЛОКО"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли виноград в корзине 1? " + basket.containsProduct("Виноград"));

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

