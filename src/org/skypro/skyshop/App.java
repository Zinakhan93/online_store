package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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

        // Добавляем во вторую корзину товары ДЗ -2
        basket4.addFood(apple);
        basket4.addFood(mango);
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





















    }
}

