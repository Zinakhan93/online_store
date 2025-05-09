package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final LinkedList<Searchable> searchables = new LinkedList<>();

    public void addSearchable(Searchable a) {
        searchables.add(a);
    }
public LinkedList<Searchable> search(String query) {
    LinkedList<Searchable> results = new LinkedList<>();
    for (Searchable a : searchables) {
        if (a.getSearchableName().toLowerCase().contains(query.toLowerCase())) {
            results.add(a);
        }
    }
    return results;
}

// Пока неуверена в его использовании
public void printSearchResults(LinkedList<Searchable> results) {
    for (Searchable item : results) {
        if (item != null) {
            System.out.println(item.getStringRepresentation());
        } else {
            System.out.println("Ничего не найдено");
        }
    }
}
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm();
            int count = countSubstringOccurrences(searchTerm.toLowerCase(), search.toLowerCase());

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0) {
            return 0;
        }

        while (true) {
            index = str.indexOf(substring, index);
            if (index == -1) {
                break;
            }
            count++;
            index += substringLength;
        }

        return count;
    }



}
