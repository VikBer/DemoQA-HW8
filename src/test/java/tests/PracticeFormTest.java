package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;



public class PracticeFormTest extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    void fillFormTest() {

            registrationPage.openPage()
                    .setFirstName("Anton")
                    .setLastName("Gorodetsky")
                    .setEmail("A.Gorodetsky@gorsvet.com")
                    .setGender("Male")
                    .setPhone("1234567891")
                    .setOfBirthInput("07", "June", "2001")
                    .setSubjects("English")
                    .setHobbies("Sports")
                    .setFile("Screenshot3.jpg")
                    .setCurrentAddress("Moscow, Sholokhova street 87, room 21")
                    .setState("Rajasthan")
                    .setCity("Jaiselmer")
                    .submit();

        {
            resultComponent.checkResult("Student Name", "Anton Gorodetsky")
                    .checkResult("Student Email", "A.Gorodetsky@gorsvet.com")
                    .checkResult("Gender", "Male")
                    .checkResult("Mobile", "1234567891")
                    .checkResult("Date of Birth", "07 June,2001")
                    .checkResult("Subjects", "English")
                    .checkResult("Hobbies", "Sports")
                    .checkResult("Picture", "Screenshot3.jpg")
                    .checkResult("Address", "Moscow, Sholokhova street 87, room 21")
                    .checkResult("State and City", "Rajasthan Jaiselmer");
        }

    }

    @Test
    void requiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Anton")
                .setLastName("Gorodetsky")
                .setGender("Male")
                .setPhone("1234567891")
                .submit();

        resultComponent.checkResult("Student Name", "Anton Gorodetsky")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567891");
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setFirstName("Anton")
                .setLastName("Gorodetsky")
                .setPhone("1234567891")
                .submit();

        resultComponent.negativeResult()
                .negativeResult();
    }

}