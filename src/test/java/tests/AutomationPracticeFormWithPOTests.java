package tests;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

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


//    @Test
//    void fillPracticeFormTest() {
//        open("/automation-practice-form");
//
//        executeJavaScript("$('footer').remove();");
//        executeJavaScript("$('#fixedban').remove();");
//
//        // Заполнение формы студента
//
//        $("#firstName").setValue("Ser");
//        $("[id=lastName]").setValue("Ple"); /* вместо id=userName можно написать #name. Работает для id и  классов */
//        $(by("id", "userEmail")).setValue("hello@ggg.com");
//        $$("label").findBy(text("Male")).click();
//        $("#userNumber").setValue("9993332211");
//
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("May");
//        $(".react-datepicker__year-select").selectOption("1999");
//        $$("div.react-datepicker__day").findBy(text("1")).click();
//
//        $("#subjectsInput").setValue("Chemistry").pressEnter();
//        $("#hobbiesWrapper").$(byText("Sports")).click();
//        $("#uploadPicture").uploadFromClasspath("priroda_kartinki_foto_03.jpg");
//        // $("#uploadPicture").uploadFile(new File("src/test/resources/PNG_transparency_demonstration_1.png"));
//        $("#currentAddress").setValue("City centre 1");
//        $("#react-select-3-input").setValue("NCR").pressEnter();
//        $("#react-select-4-input").setValue("Delhi").pressEnter();
//        $("#submit").click();
//
//        // Сравнение внесенных данных с итоговой формой
//
//        $("[class=table-responsive]").$(byText("Student Name")).parent().shouldHave(text("Ser Ple")); // или сокращенно ".table-responsive" (обращение к классу)
//        $("[class=table-responsive]").$(byText("Student Email")).parent().shouldHave(text("hello@ggg.com"));
//        $("[class=table-responsive]").$(byText("Gender")).parent().shouldHave(text("Male"));
//        $("[class=table-responsive]").$(byText("Mobile")).parent().shouldHave(text("9993332211"));
//        $("[class=table-responsive]").$(byText("Date of Birth")).parent().shouldHave(text("01 May,1999"));
//        $("[class=table-responsive]").$(byText("Subjects")).parent().shouldHave(text("Chemistry"));
//        $("[class=table-responsive]").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
//        $("[class=table-responsive]").$(byText("Picture")).parent().shouldHave(text("priroda_kartinki_foto_03.jpg"));
//        $("[class=table-responsive]").$(byText("Address")).parent().shouldHave(text("City centre 1"));
//        $("[class=table-responsive]").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
//
//    }
//
//    @Test
//    void minimumNumberOfDataIntheField() {
//
//        open("/automation-practice-form");
//        executeJavaScript("$('footer').remove();");
//        executeJavaScript("$('#fixedban').remove();");
//
//        $("[id=userNumber-wrapper]").$("[minlength]").shouldHave(attribute("minlength", "10"));
//    }
//
//    @Test
//    void inputElevenDigitsInMobileField() {
//
//        open("/automation-practice-form");
//        executeJavaScript("$('footer').remove();");
//        executeJavaScript("$('#fixedban').remove();");
//
//        // Проверка, что при добавлении 11 цифр в поле сохраняется только 10
//        $("#userNumber").setValue("99933322111").shouldHave(value("9993332211"));
//
//    }

}
