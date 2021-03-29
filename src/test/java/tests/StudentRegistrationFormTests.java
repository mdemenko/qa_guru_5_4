package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationFormTests {

    StudentRegistrationFormPage studentRegistrationFormPage  = new StudentRegistrationFormPage();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void studentCanRegister() {
        studentRegistrationFormPage.openPage()
        .fillForm()
        .checkData();
    }
}
