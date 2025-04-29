package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultRegistrationFormComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"), // Элементы страницы
    lastNameInput = $("#lastName"),
    userEmailInput = $(by("id", "userEmail")),
    genderWrapper = $("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectInput = $("#subjectsInput"),
    hobbieInput = $("#hobbiesWrapper"),
    pictureAdd =  $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    stateAdd =  $("#react-select-3-input"),
    cityAdd =  $("#react-select-4-input"),
    submitClick = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

     public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.find(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbieInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureAdd.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateAdd.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityAdd.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitClick.click();

        return this;
    }

    public RegistrationPage checkMinDigitsFieldMobile(String value) {
        userNumberInput.shouldHave(attribute("minlength", value));

        return this;
    }

    public RegistrationPage setMoreThan10DigitsMobilePhone(String value) {
        userNumberInput.setValue(value);
        String expectedValue = value.length() > 10 ? value.substring(0, 10) : value;
        System.out.println(expectedValue);

        return this;
    }

}