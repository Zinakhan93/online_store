package org.skypro.skyshop.searchEngine;
import org.skypro.skyshop.Searchable;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private  Searchable[] search;
    private int count;

    public SearchEngine(int size) {
        search = new Searchable[size];
        count=0;
    }

    public void add(Searchable a) {
        if (count < search.length) {
            search[count] = a;
            count++;
        } else {
            System.out.println( "Невозможно добавить элемент, массив полон.");
        }
    }
    public Searchable[] search(String term) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable a : search) {
            if (a != null && a.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(a);
                if (results.size() == 5) { // Ограничиваем до 5 результатов.
                    break;
                }
            }
        }
        return results.toArray(new Searchable[0]);
    }



}
