package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomFakerUtils {

    Faker faker = new Faker(new Locale("ru"));

    public String firstName = faker.name().firstName(); // Emory
    public String lastName = faker.name().lastName(); // Barton
    public String userEmail = faker.internet().emailAddress();
    public String userGender = faker.;
    public String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449




}

