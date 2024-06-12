package org.example.utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String generateDate() {
        return faker.date().birthday().toString(); // Exemplo, ajuste conforme necessário
    }
}
