import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudFormDemoQATest {
    @BeforeAll
    static void testConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    
    @Test
    void fullFillRegFormTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Gorodetsky");
        $("#userEmail").setValue("A.Gorodetsky@gorsvet.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8999123456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--007").click();
        $("#subjectsInput").val("Math").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("Screenshot3.jpg");
        $("#currentAddress").setValue("Moscow, Sholokhova street 87, room 21");
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#react-select-4-input").val("Jaiselmer").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Anton Gorodetsky"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("A.Gorodetsky@gorsvet.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999123456"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("07 June,2001"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Screenshot3.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Moscow, Sholokhova street 87, room 21"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaiselmer"));

        $("#closeLargeModal").click();
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}


