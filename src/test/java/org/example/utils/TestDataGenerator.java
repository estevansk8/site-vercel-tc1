package org.example.utils;

import com.github.javafaker.Faker;

public class TestDataGenerator {
    private static Faker faker = new Faker();

    public static String generateCodigo() {
        return faker.number().toString();
    }
    public static String generateDescricao() {
        return faker.commerce().productName();
    }

    public static String generateDataValidade() {
        return String.format("%02d/%02d/%04d", faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28), faker.number().numberBetween(2023, 2025));
    }

    public static String generatePeso() {
        return String.valueOf(faker.number().randomDouble(2, 1, 100));
    }

    public static String generateAltura() {
        return String.valueOf(faker.number().numberBetween(1, 100));
    }

    public static String generateLargura() {
        return String.valueOf(faker.number().numberBetween(1, 100));
    }

    public static String generateVolume() {
        return String.valueOf(faker.number().numberBetween(1, 10000));
    }

    public static String generateFragilidade() {
        String[] fragilidadeOptions = {"Fragil", "Segura", "Contida"};
        return faker.options().option(fragilidadeOptions);
    }
}