package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import pages.components.ResultRegistrationFormComponent;
import utils.RandomFakerUtils;

import static utils.RandomFakerUtils.*;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            phoneNumber = getRandomPhone(),
            dayOfBirth = getRandomDayOfBirth(),
            monthOfBirth = getRandomMonthOfBirth(),
            yearOfBirth = getRandomYearOfBirth(),
            subject = getRandomSubject(),
            hobbies = getRandomHobbies(),
            picture = getRandomPicture(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state);


    RegistrationPage registrationPage = new RegistrationPage();
    ResultRegistrationFormComponent resultRegistrationFormComponent = new ResultRegistrationFormComponent();



    @Test
    void successfulRegistrationTest() {

        // Проверка успешности заполнения регистрационной формы студента

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth , yearOfBirth)
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        resultRegistrationFormComponent.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth +  "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);

    }

    @Test
    void minimumNumberOfDataIntheFieldTest() {

        // Проверка минимального кол-ва символов в поле Mobile

        registrationPage.openPage()
                .checkMinDigitsFieldMobile("10");
    }

    @Test
    void inputElevenDigitsInMobileField() {

        // Негативная проверка. Ввод более 10 цифр в поле Mobile

        registrationPage.openPage()
                .setMoreThan10DigitsMobilePhone("99955544433222");
    }

}
