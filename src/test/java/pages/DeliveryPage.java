package pages;

import static com.codeborne.selenide.Selenide.$;

public class DeliveryPage {

    public DeliveryPage setDateOfDelivery(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        return this;
    }

}
