package gmail.AwarenessLightA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomPracticeForm {

    @BeforeAll
    static void setMaxBrowserSize() {
        Configuration.startMaximized = true;

    }

    @Test
    void fillingStudentRegForm() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Picaboo");
        $("#lastName").setValue("Pincertone");
        $("#userEmail").setValue("Picaboo@boo.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("7777318585");
        $("#dateOfBirthInput").click();
        $("[class*='year-select']").selectOptionContainingText("1985");
        $("[class*='month-select']").selectOptionContainingText("December");
        $("[class*='day--019']").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\Aware\\Leopard.jpg"));
        $("#currentAddress").setValue("Moscow, Vernadsky st., 50, ap.77");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Agra").pressEnter();
        $("[id=submit]").pressEnter();
    }

    @Test
    void checkingCorrectOfDataInSubmittedForm() {
        $(byText("Picaboo Pincertone")).shouldBe(visible, Duration.ofSeconds(5));
        $(byText("Picaboo@boo.com")).shouldBe(visible);
        $(byText("Male")).shouldBe(visible);
        $(byText("7777318585")).shouldBe(visible);
        $(byText("19 December,1985")).shouldBe(visible);
        $(byText("Computer Science")).shouldBe(visible);
        $(byText("Music")).shouldBe(visible);
        $(byText("Leopard.jpg")).shouldBe(visible);
        $(byText("Moscow, Vernadsky st., 50, ap.77")).shouldBe(visible);
        $(byText("Uttar Pradesh Agra")).shouldBe(visible);

        sleep(5000);
    }
}