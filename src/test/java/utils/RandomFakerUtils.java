package utils;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFakerUtils {

    private static final Faker faker = new Faker(new Locale("en-GB"));


    // Рандомное имя

    public static String getRandomFirstName(){
        return faker.name().firstName();
    };

    // Рандомная фамилия

    public static String getRandomLastName(){
        return faker.name().lastName();
    };

    // Рандомный email

    public static String getRandomEmail(){
        return faker.internet().emailAddress();
    };

    // Рандомный пол

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    // Рандомный телефон

    public static String getRandomPhone() {

        return String.format("%s%s%s%s", getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    // Рандомный день рождения

    public static String getRandomDayOfBirth() {
        int dayOfBirth = faker.number().numberBetween(1, 28);
        return String.format("%02d", dayOfBirth);
    }

    // Рандомный месяц рождения

    public static String getRandomMonthOfBirth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    // Рандомный год рождения

    public static String getRandomYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1990, 2010));
    }

    // Рандомный предмет

    public static String getRandomSubject() {
        return faker.options().option("English", "Hindi", "Maths", "Arts", "Accounting", "Commerce", "Economics", "Computer Science", "History", "Civics");
    }

    // Рандомное хобби

    public static String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    // Рандомная картинка

    public static String getRandomPicture() {
        return faker.options().option("priroda_kartinki_foto_03.jpg", "1119-white-flower-2_1579261223.jpg");
    }

    // Рандомный адрес

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    // Рандомный штат

    public static String getRandomState() {
        return faker.options().option(
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    // Рандомный город

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException(
                    "Неизвестное значение state: " + state);
        };
    }

    // Строка с числом 10 для теста minimumNumberOfDataIntheFieldTest

    public static String getNumber10() {
        return String.valueOf(faker.number().numberBetween(10, 10));
    }

    // Генерация телефонного номера в котором > 10 цифр

    public static String getInvalidNumber() {

        return String.format("%s%s%s%s%s", getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99), getRandomInt(1111, 9999));
    }
}



