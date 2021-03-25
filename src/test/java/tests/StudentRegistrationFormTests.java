package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTests {

    StudentRegistrationFormPage studentRegistrationFormPage;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentCanRegister() {
        studentRegistrationFormPage  = new StudentRegistrationFormPage();

        studentRegistrationFormPage.openPage();
        studentRegistrationFormPage.fillForm();
        studentRegistrationFormPage.checkData();
    }
}
