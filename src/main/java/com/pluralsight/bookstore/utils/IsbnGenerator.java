package com.pluralsight.bookstore.utils;

import java.util.Random;

public class IsbnGenerator implements  NumberGenerator {
    @Override
    public String generateNumber() {
        return "13-8456-" + Math.abs(new Random().nextInt());
    }
}
