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
                .setGender("Male")
                .setUserNumber("5550009995")
                .setDateOfBirth("30", "June", "2004")
                .setSubject("Chemistry")
                .setHobbie("Sports")
                .uploadPicture("priroda_kartinki_foto_03.jpg")
                .setCurrentAddress("ul. New Delhi 4")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .clickSubmit();

        resultRegistrationFormComponent.checkResult("Student Name", "Serg Plechko")
                .checkResult("Student Email", "serg@plechko.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "5550009995")
                .checkResult("Date of Birth", "30 June,2004")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "priroda_kartinki_foto_03.jpg")
                .checkResult("Address", "ul. New Delhi 4")
                .checkResult("State and City", "Rajasthan Jaipur");
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
