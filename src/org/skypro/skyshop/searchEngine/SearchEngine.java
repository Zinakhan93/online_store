package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

import java.util.*;

public class SearchEngine {
    private final Set <Searchable> searchables = new HashSet<>();


    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getSearchableName().length(), s1.getSearchableName().length());
            if (lengthCompare == 0) {
                return s1.getSearchableName().compareTo(s2.getSearchableName());
            }
            return lengthCompare;
        }
    }

    private static final Comparator<Searchable> SEARCHABLE_COMPARATOR = new SearchableComparator();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public TreeSet< Searchable> search(String query) {
        TreeSet<Searchable> results = new TreeSet<>(SEARCHABLE_COMPARATOR);
        String queryLower = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item.getSearchableName().toLowerCase().contains(queryLower)) {
                results.add(item);
            }
        }
        return results;
    }

    public void printSearchResults(TreeSet<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }

        for (Searchable item : results) {
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




























