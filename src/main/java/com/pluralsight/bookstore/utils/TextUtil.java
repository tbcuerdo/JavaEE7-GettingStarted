package com.pluralsight.bookstore.utils;

public class TextUtil {
    public String sanitize(String toSanitize) {
        return toSanitize.replaceAll("\\s+", " ");
    }
}
