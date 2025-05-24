package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import pages.components.ResultRegistrationFormComponent;

import static io.qameta.allure.Allure.step;
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
            city = getRandomCity(state),

            number10ForTestMinimumNumberOfDataIntheField = getNumber10(),
            invalidNumberForNegativeTest = getInvalidNumber();


    RegistrationPage registrationPage = new RegistrationPage();
    ResultRegistrationFormComponent resultRegistrationFormComponent = new ResultRegistrationFormComponent();



    @Test
    @Tag("homework_test")
    @DisplayName("User registration")
    void successfulRegistrationTest() {

        step("Fill in all fields by valid data", () -> {
            registrationPage.openPage()
                    .removeBanner()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setUserNumber(phoneNumber)
                    .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                    .setSubject(subject)
                    .setHobbie(hobbies)
                    .uploadPicture(picture)
                    .setCurrentAddress(address)
                    .setState(state)
                    .setCity(city);
        });

        step("Click Submit", () -> {
            registrationPage.clickSubmit();
        });

        step("Expected result: Adding data corresponds to the data in final registration form", () -> {
            resultRegistrationFormComponent.checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobbies)
                    .checkResult("Picture", picture)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }

    @Test
    @Tag("homework_test")
    @DisplayName("Checking minimum total of symbols in the Mobile field")
    void minimumNumberOfDataIntheFieldTest() {

        step("Expected result: minimum quantity of the symbols in the Mobile field is equal 10", () -> {
            registrationPage.openPage()
                    .checkMinDigitsFieldMobile(number10ForTestMinimumNumberOfDataIntheField);
        });
    }

    @Test
    @Tag("homework_test")
    @DisplayName("Input more than 10 digits in the Mobile field")
    void inputElevenDigitsInMobileField() {

        step("Expected result: It's impossible to input more than 10 digits in the Mobile field", () -> {
            registrationPage.openPage()
                    .setMoreThan10DigitsMobilePhone(invalidNumberForNegativeTest);
        });
    }
}
