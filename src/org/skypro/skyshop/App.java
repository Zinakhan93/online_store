package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("App.main");
        ProductBasket basket = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();
        ProductBasket basket3 = new ProductBasket();
        ProductBasket basket4 = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 200);
        Product mango = new DiscountedProduct("Манго", 300, 25);
        Product cheese = new FixPriceProduct("Сыр");
        Product chocolate = new FixPriceProduct("Шоколад");
        Product juice = new DiscountedProduct("Сок", 120, 10);
        Product orange = new SimpleProduct("Апельсин", 200);
        DiscountedProduct banana = new DiscountedProduct("Банан", 80, 20);


        basket4.addProduct(apple);
        basket4.addProduct(banana);
        basket4.addProduct(chocolate);
        basket4.addProduct(cheese);
        basket4.addProduct(juice);
        basket4.addProduct(orange);

        System.out.println("Содержимое корзины № 4");
        basket4.printBasket();

        // Получение стоимости корзины c несколькими товарами
        System.out.println("Общая стоимость корзины 4: " + basket4.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко в корзине 4? " + basket4.containsProduct("ЯБЛОКО"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли виноград в корзине 4? " + basket4.containsProduct("Виноград"));

        // Очистка корзины
        basket4.cleaningTheBasket();

        // Печать содержимого пустой корзины
        basket4.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket4.getTotalPrice());

        // Поиск товара по имени в пустой корзине
        System.out.println("Содержит ли пустая корзина яблоко? " + basket4.containsProduct("Яблоко"));

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(juice);
        searchEngine.add(banana);
        searchEngine.add(chocolate);

        // Создание статей и добавление их в поисковый движок.
        Article article1 = new Article("Яблоко", " Полезны для здоровья.");
        Article article2 = new Article("Сок ", "из натуральных фруктов полезен для здоровья");
        Article article4 = new Article("Шоколад", "Полезно ");
        Article article5 = new Article("Апельсин", "Витамин С");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article4);
        searchEngine.add(article5);
        System.out.println("Проверка");



        System.out.println("Поиск по слову 'Апельсин':");
        searchEngine.printSearchResults(searchEngine.search("Апельсин"));
        System.out.println("Дз 4");

        try {
            Product potato = new SimpleProduct("картошка", -10);
        } catch (IllegalArgumentException a) {
            System.out.println(a.getMessage());
        }
        try {
            Product carrot = new DiscountedProduct(" ", 50, 95);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nПоиск самого подходящего элемента:");

        try {
            Searchable bestMatch = searchEngine.findBestMatch("из");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }






    }
}
