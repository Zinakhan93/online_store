package org.skypro.skyshop.searchEngine;
import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private final Searchable[] items ;
    private int count =0;

    public SearchEngine(int size) {
        items = new Searchable[size];

    }

    public void add(Searchable a) {
        if (count <items .length) {
            items[count] = a;
            count++;
        } else {
            System.out.println("Невозможно добавить элемент, массив полон.");
        }
    }
    // Метод для поиска элементов по строке
    public Searchable[] search (String word){
        Searchable[] results = new Searchable[5]; // Массив для хранения результатов поиска
        int foundCount = 0; // Счетчик найденных элементов

        for (int i = 0; i < items.length; i++) { // Проход по всем элементам массива
            if (items[i] != null && items[i].getSearchTerm().contains(word)){ // Проверка на соответствие строки поиска
                results[foundCount] = items[i]; // Добавление найденного элемента в результаты
                foundCount++; // Увеличение счетчика найденных элементов

                if (foundCount == results.length) { // Проверка на заполнение массива результатов
                    break;

                }
            }
        }

        return results; // Возврат массива результатов поиска
    }

    // Пока неуверена в его использовании
    public void printSearchResults(Searchable[] results) {
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            } else {
                System.out.println("Ничего не найдено");
            }
        }
    }





}
