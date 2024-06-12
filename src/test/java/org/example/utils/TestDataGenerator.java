package org.example.utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String generateCodigo() {
        return faker.number().toString();
    }

}