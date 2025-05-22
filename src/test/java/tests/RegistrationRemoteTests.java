package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests {

    @BeforeAll
    static void actionsBeforeTestingRegistrationForm() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; // подключили удаленную ферму, чтобы локально не юзать браузер (жрет дохрена ресурсов)
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // Добавили логгер, который будет логировать все селенидовские шаги
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot"); // мы взяли метод screenshot и таким образом его вызываем

    }

    @Test
    @Tag("demoqa")
    void successfulRegistrationTest() {
        step("Open form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Alex");
            $("#lastName").setValue("Egorov");
            $("#userEmail").setValue("alex@egorov.com");
            $("#genterWrapper").$(byText("Other")).click();
            $("#userNumber").setValue("1234567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2008");
            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
        });
//        step("Verfy result", () -> {
//            $(".modal-dialog").should(appear);
//            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//            $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
//                    text("alex@egorov.com"), text("1234567890"));
//        });

//        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#currentAddress").setValue("Some address 1");
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#city").click();
//        $("#stateCity-wrapper").$(byText("Delhi")).click();
//        $("#submit").click();

    }
}