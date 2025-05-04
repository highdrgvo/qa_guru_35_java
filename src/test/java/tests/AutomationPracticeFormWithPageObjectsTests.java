package tests;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegistrationPage;
import pages.components.ResultRegistrationFormComponent;
import utils.RandomFakerUtils;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(AutomationPracticeFormWithPageObjectsTests.class);
    RegistrationPage registrationPage = new RegistrationPage();
    ResultRegistrationFormComponent resultRegistrationFormComponent = new ResultRegistrationFormComponent();
    RandomFakerUtils randomFaker = new RandomFakerUtils();

    @Test
    void successfulRegistrationTest() {

        // Проверка успешности заполнения регистрационной формы студента

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(randomFaker.firstName)
                .setLastName(randomFaker.lastName)
                .setEmail(randomFaker.userEmail)
                .setGender(randomFaker.userGender)
                .setUserNumber(randomFaker.userNumber)
                .setDateOfBirth(randomFaker.userDayOfBirth, randomFaker.monthOfBirth, randomFaker.userYearOfBirth)
                .setSubject(randomFaker.userSubject)
                .setHobbie(randomFaker.userHobbies)
                .uploadPicture(randomFaker.userPicture)
                .setCurrentAddress(randomFaker.streetAddress)
                .setState(randomFaker.state)
                .setCity(randomFaker.city)
                .clickSubmit();

        resultRegistrationFormComponent.checkResult("Student Name", randomFaker.firstName + " " + randomFaker.lastName)
                .checkResult("Student Email", randomFaker.userEmail)
                .checkResult("Gender", randomFaker.userGender)
                .checkResult("Mobile", randomFaker.userNumber)
                .checkResult("Date of Birth", randomFaker.userDayOfBirth + " " + randomFaker.monthOfBirth +  "," + randomFaker.userYearOfBirth)
                .checkResult("Subjects", randomFaker.userSubject)
                .checkResult("Hobbies", randomFaker.userHobbies)
                .checkResult("Picture", randomFaker.userPicture)
                .checkResult("Address", randomFaker.streetAddress)
                .checkResult("State and City", randomFaker.state + " " + randomFaker.city);

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
