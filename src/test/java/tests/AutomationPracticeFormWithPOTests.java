package tests;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormWithPOTests extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(AutomationPracticeFormWithPOTests.class);
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Serg")
                .setLastName("Plechko")
                .setEmail("serg@plechko.com")
                .setGender("Male")
                .setUserNumber("5550009995")
                .setDateOfBirth("01", "May", "2001")
                .setSubject("Chemistry")
                .setHobbie("Sports")
                .uploadPicture("priroda_kartinki_foto_03.jpg")
                .setCurrentAddress("ul. New Delhi 4")
                .setState("Rajasthan")
                .setCity("Jaipur")
                .clickSubmit()

                .checkResult("Student Name", "Serg Plechko")
                .checkResult("Student Email", "serg@plechko.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "5550009995")
                .checkResult("Date of Birth", "01 May,2001")
                .checkResult("Subjects", "Chemistry")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "priroda_kartinki_foto_03.jpg")
                .checkResult("Address", "ul. New Delhi 4")
                .checkResult("State and City", "Rajasthan Jaipur");


        sleep(5000);


    }

    @Test
    void minimumNumberOfDataIntheFieldTest() {

        // В поле Mobile минимальное кол-во цифр = 10

        registrationPage.openPage()
                .checkMinDigitsFieldMobile("10");
    }

    @Test
    void inputElevenDigitsInMobileField() {

        // Ввод более 10 цифр в поле Mobile

        registrationPage.openPage()
                .setMoreThan10DigitsMobilePhone("99955544433222");
    }

}
