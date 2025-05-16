package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("App.main");
        ProductBasket basket4 = new ProductBasket();

        // Перечисляем продукты которые есть по спец.ценам
        Product apple = new SimpleProduct("Яблоко", 200);
        Product mango = new DiscountedProduct("Манго", 300, 25);
        Product cheese = new FixPriceProduct("Сыр");
        Product chocolate = new FixPriceProduct("Шоколад");
        Product juice = new DiscountedProduct("Сок", 120, 10);
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
        basket4.printBasket();

        // Получение стоимости корзины c несколькими товарами
        System.out.println("Общая стоимость корзины 4: " + basket4.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко в корзине 4? " + basket4.containsProduct("ЯБЛОКО"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли виноград в корзине 4? " + basket4.containsProduct("Виноград"));
        System.out.println("\nСодержимое корзины до удаления:");
        basket4.printBasket();

        System.out.println("\nУдаляем продукт 'Яблоко':");
        List<Product> removedProducts = basket4.removeProductsByName("Яблоко");
        if (!removedProducts.isEmpty()) {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }
        System.out.println("\nСодержимое корзины после удаления:");
        basket4.printBasket();
        System.out.println("\nПытаемся удалить продукт 'Манго':");
        removedProducts = basket4.removeProductsByName("Манго");
        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст");
        }
        System.out.println("\nСодержимое корзины после попытки удаления:");
        basket4.printBasket();

        basket4.cleaningTheBasket();
        System.out.println("\nСодержимое корзины 4 после очистки:");

        basket4.printBasket();
        System.out.println("\nОбщая стоимость корзины 4 после очистки: " + basket4.getTotalPrice());
        System.out.println("\nВ корзине после очистки 4 есть Яблоко: " + basket4.containsProduct("Яблоко"));





        // Создание поискового движка и добавление товаров и статей.
        System.out.println("Дз -3");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addSearchable(apple);
        searchEngine.addSearchable(juice);
        searchEngine.addSearchable(banana);
        searchEngine.addSearchable(chocolate);

        // Создание статей и добавление их в поисковый движок.
        Article article1 = new Article("Яблоко", " Полезны для здоровья.");
        Article article2 = new Article("Сок ", "из натуральных фруктов полезен для здоровья");
        Article article4 = new Article("Шоколад", "Полезно ");
        Article article5 = new Article("Апельсин", "Витамин С");

        searchEngine.addSearchable(article1);
        searchEngine.addSearchable(article2);
        searchEngine.addSearchable(article4);
        searchEngine.addSearchable(article5);
        //Можно добавить еще и так
        searchEngine.addSearchable(new Article("Апельсин", "Витамин С"));;

        System.out.println("Проверка");

        System.out.println("Результат по поиска по 'Сок':");
        searchEngine.printSearchResults(searchEngine.search("сок"));
        System.out.println("Результат по поиска по 'Витамин':");
        searchEngine.printSearchResults(searchEngine.search("Витамин"));

        System.out.println("Результат по поиска по 'Апельсин':");
        searchEngine.printSearchResults(searchEngine.search("Апельсин"));

        // Исключения
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
        try {
            Product zeroPriceProduct = new SimpleProduct("Телефон", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
        try {
            Product cake = new DiscountedProduct("Торт", 3000, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        } finally {
            System.out.println("Проверка завершена");
        }
        System.out.println("\nПроверка при добавлении новых статей");
        try {
            Article emptyTitleArticle = new Article(" ", "Пустое название");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании статьи: " + e.getMessage());
        }
        System.out.println("\nПоиск самого подходящего элемента:");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании поискового запроса: " + e.getMessage());
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        }
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Яблоко");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Сок");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }












    }
}
