package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests {

    // Что такое PAgeObject? Надо почитать.

    @Test
    void successfulRegistrationTest() {

        registrationPage.open()
            .setFirstName("Alex")
            .setGender("Alex")
            .setBirthDay("30", "July", "2008")
            .checkFormAppears()


            .checkRelust("Full Name", "Alex Egorov");

    }
}
