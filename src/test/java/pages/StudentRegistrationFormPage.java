package pages;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress();

    public StudentRegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public StudentRegistrationFormPage fillForm(){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(mobile);
        setBirthDate("2000", "June");

        //select subjects
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();

        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("image.jpg");
        $("#currentAddress").setValue(currentAddress);

        //select state and city
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        return this;
    }

    public void checkData() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(byText(firstName + " " + lastName)).shouldBe(visible);
        $(byText("Male")).shouldBe(visible);
        $(".modal-content").shouldHave(text(email),
                text(mobile), text("01 June,2000"), text("Maths, English"),
                text("Sports, Music"), text(currentAddress), text("NCR Delhi"), text("image.jpg"));
    }

    private void setBirthDate(String year, String month) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $$(".react-datepicker__day--001").first().click();
    }
}
