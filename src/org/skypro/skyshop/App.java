package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;

public class App {
    public static void main(String[] args) {
        System.out.println("App.main");
        ProductBasket basket= new ProductBasket();
        ProductBasket basket2= new ProductBasket();
        ProductBasket basket3= new ProductBasket();
        ProductBasket basket4= new ProductBasket();

        // Добавляем продуктов в корзину
        Product apple = new SimpleProduct("Яблоко", 200);
        Product mango = new DiscountedProduct("Манго", 300,25);
        Product cheese = new FixPriceProduct("Сыр");
        Product chocolate = new FixPriceProduct("Шоколад");
        Product juice = new DiscountedProduct("Сок",120,10);
        Product orange = new SimpleProduct("Апельсин", 200);
        DiscountedProduct banana = new DiscountedProduct("Банан", 80, 20);


        // Добавляем во вторую корзину товары ДЗ -2
        basket4.addFood(apple);
        basket4.addFood(banana);
        basket4.addFood(chocolate);
        basket4.addFood(cheese);
        basket4.addFood(juice);
        basket4.addFood(orange);

        System.out.println("Содержимое корзины № 4");
        basket4.printContents();

        // Получение стоимости корзины c несколькими товарами
        System.out.println("Общая стоимость корзины 4: " + basket4.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко в корзине 4? " + basket4.containsProduct("ЯБЛОКО"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли виноград в корзине 4? " + basket4.containsProduct("Виноград"));

        // Очистка корзины
        basket4.clearBasket();

        // Печать содержимого пустой корзины
        basket4.printContents();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket4.getTotalPrice());

        // Поиск товара по имени в пустой корзине
        System.out.println("Содержит ли пустая корзина яблоко? " + basket4.containsProduct("Яблоко"));

        // Создание поискового движка и добавление товаров и статей.
        System.out.println("Дз -3");
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(apple);
        searchEngine.add(juice);
        searchEngine.add(banana);
        searchEngine.add(chocolate);


        // Создание статей и добавление их в поисковый движок.
        Article article1 = new Article("Польза яблок", "Яблоки полезны для здоровья.");
        Article article2 = new Article("Сок ", "Сок из натуральных фруктов полезен для здоровья");
        Article article3 = new Article("Бананы", "Бананы содержат много калия.");
        Article article4 = new Article("Шоколад", "Полезно для мозга");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        // Поиск по товарам и статьям.
        System.out.println("Результаты поиска 'яблоко':");
        for (Searchable result : searchEngine.search("яблоко")) {
            System.out.println(result.getStringRepresentation());
        }
        System.out.println("\nРезультаты поиска 'сок':");
        for (Searchable result : searchEngine.search("сок")) {
            System.out.println(result.getStringRepresentation());
        }


        System.out.println("\nРезультаты поиска 'банан':");
        for (Searchable result : searchEngine.search("банан")) {
            System.out.println(result.getStringRepresentation());
        }
        System.out.println("\nРезультаты поиска 'шоколад':");
        for (Searchable result : searchEngine.search("шоколад")) {
            System.out.println(result.getStringRepresentation());
        }
























    }
}

