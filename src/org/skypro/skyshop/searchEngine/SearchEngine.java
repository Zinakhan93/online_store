package org.skypro.skyshop.searchEngine;
import org.skypro.skyshop.BestResultNotFound;
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
// Дз -4
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }
        int maxCount = 0;// Переменная для хранения максимального количества вхождений
        Searchable bestMatch = null;// Переменная для хранения лучшего совпадения

        for (Searchable item : items) {
            String term = item.getSearchTerm();// Получаем строку поиска из объекта
            int count = countOccurrences(term, search);
            // Если текущее количество вхождений больше максимального, обновляем bestMatch
            if (count > maxCount) {
                maxCount = count;// Счетчик вхождений
                bestMatch = item;// Индекс для поиска
            }
        }

        // Если ни одного вхождения не найдено, выбрасываем исключение
        if (maxCount == 0) {
            throw new BestResultNotFound ("Не найдено подходящих объектов для запроса: " + search);
        }

        return bestMatch;
    }
    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }












}
