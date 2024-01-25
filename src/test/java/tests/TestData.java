package tests;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String
            email = faker.internet().emailAddress(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            gender = faker.options().option("Male", "Female", "Other"),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d",faker.number().numberBetween(1,28)),
            month = faker.options().option("January", "February", "March",
                    "April", "May", "June",
                    "July", "August", "September",
                    "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1976,2015)),
            subjects = faker.options().option("Math", "English", "Computer science",
                    "Commerce", "Chemistry", "Economics",
                    "Social studies", "Arts", "Biology",
                    "Civics", "Physics", "History"),
            hobbie = faker.options().option("Sports", "Reading", "Music"),
            streetAddress = faker.address().streetAddress(),
            fileName = "Screenshot3.jpg",
             state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);

    public String getRandomCity(String state) {

        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }
    }
}
