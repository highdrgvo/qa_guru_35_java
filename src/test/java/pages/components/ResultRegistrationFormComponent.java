package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultRegistrationFormComponent {

    public ResultRegistrationFormComponent checkResult(String key, String value) {

        $("[class=table-responsive]").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
