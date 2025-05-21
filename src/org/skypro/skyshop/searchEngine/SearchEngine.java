package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

 hw-6
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        String queryLower = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item.getName().toLowerCase().contains(queryLower)) {
                results.put(item.getName(), item);
            }
        }
        return results;
    }

    public void printSearchResults(Map<String, Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }

        for (Searchable item : results.values()) {
            System.out.println(item.getStringRepresentation());
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;
        String searchLower = search.toLowerCase();

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();
            int count = countSubstringOccurrences(searchTerm, searchLower);


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

master
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }
 hw-6


 master
        if (maxCount == 0) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }
 hw-6


 master
    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();
hw-6
        if (substringLength == 0) {
            return 0;


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
 master
        }
        while (true) {
            index = str.indexOf(substring, index);
            if (index == -1) {
                break;
            }
            count++;
            index += substringLength;
        }return count;
    }
}














hw-6









}
 master
