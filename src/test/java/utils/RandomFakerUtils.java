package utils;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFakerUtils {

    static Faker faker = new Faker(new Locale("en-GB"));

    public String firstName = faker.name().firstName(), // Emory
            lastName = faker.name().lastName(), // Barton
            userEmail = faker.internet().emailAddress(),
            userGender = getRandomGender(),
            userNumber = getRandomPhone(),
            monthOfBirth = getRandomMonthOfBirth(),
            userDayOfBirth = getRandomDayOfBirth(),
            userYearOfBirth = getRandomYearOfBirth(),
            userSubject = getRandomSubject(),
            userHobbies = getRandomHobbies(),
            userPicture = getRandomPicture(),
            streetAddress = faker.address().streetAddress(),
            state = getRandomState(),
            city = getRandomCity(state);


    // Рандомный пол

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {

        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {

        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    // Рандомный телефон

    public static String getRandomPhone() {

        return String.format("%s%s%s%s", getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    // Рандомный день

    public static String getRandomDayOfBirth() {
        int dayOfBirth = faker.number().numberBetween(1, 28);
        return String.format("%02d", dayOfBirth);
    }

    // Рандомный месяц

    public static String getRandomMonthOfBirth() {
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return getRandomItemFromArray(month);
    }

    // Рандомный год

    public static String getRandomYearOfBirth() {
        int yearOfBirth = (faker.number().numberBetween(1990, 2010));
        return String.valueOf(yearOfBirth);
    }

    // Рандомный предмет

    public static String getRandomSubject() {
        String[] subject = {"English", "Hindi", "Maths", "Arts", "Accounting", "Commerce", "Economics", "Computer Science", "History", "Civics"};
        return getRandomItemFromArray(subject);
    }

    // Рандомное хобби

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    // Рандомная картинка

    public static String getRandomPicture() {
        String[] picture = {"priroda_kartinki_foto_03.jpg", "1119-white-flower-2_1579261223.jpg"};
        return getRandomItemFromArray(picture);
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
}



