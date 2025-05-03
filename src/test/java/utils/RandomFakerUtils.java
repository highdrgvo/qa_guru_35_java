package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import javax.print.DocFlavor;
import java.time.Month;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class RandomFakerUtils {

    static Faker faker = new Faker(new Locale("ru"));

    public String firstName = faker.name().firstName(), // Emory
                    lastName = faker.name().lastName(), // Barton
                    userEmail = faker.internet().emailAddress(),
                    userGender = getRandomGender(),
                    userNumber = faker.phoneNumber().cellPhone(),
                    monthOfBirth = getRandomMonthOfBirth(),
                    userDayOfBirth = getRandomDayOfBirth(),
                    userYearOfBirth = getRandomYearOfBirth();

    public String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449


    // Рандомный пол

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {

        String[] genders = {"Male", "Female", "Other"};

        return  getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {

        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    // Рандомный день месяца

//    public static String getRandomDayOfBirth() {
//
//        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
//
//        return  getRandomItemFromArray(days);
//    }

    // Рандомный день

    public static String getRandomDayOfBirth() {

        int dayOfBirth = faker.number().numberBetween(1, 28);

        return String.valueOf(dayOfBirth);
    }


    // Рандомный месяц

    public static String getRandomMonthOfBirth() {

        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        return  getRandomItemFromArray(month);
    }

    // Рандомный год

    public static String getRandomYearOfBirth() {

        int yearOfBirth = faker.number().numberBetween(1980, 2007);

        return String.valueOf(yearOfBirth);
    }


}

