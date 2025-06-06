package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set <Searchable> searchables = new HashSet<>();

    private static final Comparator<Searchable> SEARCHABLE_COMPARATOR = Comparator.comparingInt((Searchable s) -> s.getSearchableName().length())
            .reversed()
            .thenComparing(Searchable::getSearchableName);

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public TreeSet< Searchable> search(String query) {
        String queryLower = query.toLowerCase();
        return searchables.stream()
                .filter(item -> item.getSearchableName().toLowerCase().contains(queryLower))
                .collect(Collectors.toCollection(()-> new TreeSet<>(SEARCHABLE_COMPARATOR)));
    }

    public void printSearchResults(TreeSet<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }
        results.forEach(item -> System.out.println(item.getStringRepresentation()));


    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        return searchables.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(item -> countSubstringOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase())))
                .filter(item -> countSubstringOccurrences(item.getSearchTerm().toLowerCase(), search.toLowerCase()) > 0)
                .orElseThrow(() -> new BestResultNotFound(search));
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




























