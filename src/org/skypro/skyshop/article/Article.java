package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return title + "\n"  + text;
    }
// Наследуемые методы
    @Override
    public String getSearchTerm() {
        return title + " " + text; // Возвращаем название и текст статьи для поиска;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;// Имя - это название статьи.
    }
}
