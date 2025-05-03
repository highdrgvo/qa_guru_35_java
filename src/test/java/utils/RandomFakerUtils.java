package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomFakerUtils {

    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton
    String userEmail = faker.internet().emailAddress();
    String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
}
