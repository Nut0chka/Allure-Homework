package ru.netology.patterns;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int addDays) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Краснодар", "Архангельск", "Астрахань", "Владикавказ", "Саратов", "Рязань",
                "Владимир", "Волгоград", "Вологда", "Воронеж", "Пермь", "Екатеринбург", "Тверь", "Тула", "Новосибирск", "Челябинск", "Иркутск", "Уфа",
                "Самара", "Хабаровск", "Омск", "Оренбург", "Пенза", "Псков", "Ижевск", "Калуга"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateWrongPhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.numerify("####");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}