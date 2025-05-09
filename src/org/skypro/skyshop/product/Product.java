package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private  String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название строки не может быть пустым или равным null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name + ": " + getPrice();
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}

