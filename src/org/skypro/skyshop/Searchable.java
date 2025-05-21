package org.skypro.skyshop;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName();
    }


}
