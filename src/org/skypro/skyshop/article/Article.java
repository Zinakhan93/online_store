package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        if (title==null || title.isBlank()){
            throw new IllegalArgumentException("Название статьи не может быть пустым или null");
        }
        this.title = title;
        if (text==null|| text.isBlank()){
            throw new IllegalArgumentException("Текст статьи не может быть пустым или null");
        }
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }
    @Override
    public String getSearchableName() {
        return title;
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }
    @Override
    public String toString() {
        return title  + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
