package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class  Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int  getPrice();
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

