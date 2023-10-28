import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudFormDemoQATest {
    @BeforeAll
    static void testConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }
    @Test
    void fullFillRegFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Gorodetsky");
        $("#userEmail").setValue("A.Gorodetsky@gorsvet.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("8999123456");
        $("#userNumber").setValue("8999123456");
    }
}
