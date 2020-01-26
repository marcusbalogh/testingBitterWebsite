/*
 * Ensure the following tests are included in your tests:
    Attempt to create an account with valid information [x]
    Attempt to create an account with invalid information [x]
    Attempt to login with valid information [x]
    Attempt to login with invalid information [x]
    Attempt to create a tweet with valid information
 */
package qa_bitter_testing;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Marcu Balogh
 */
public class QA_Bitter_Testing {
// Java Faker

    static Faker faker = new Faker();

    // Variables
    static String fname = faker.name().firstName() + "nya";
    static String lname = faker.name().lastName();
    static String email = fname + "." + lname + "@gmail.com";
    static String username = fname + "." + lname + "123";
    static String password = faker.bothify("###???###");
    static String confirmPassword = password;
    static String phone = "123 123 1234";
    static String address = faker.address().streetAddress();
    static String province_byValue = "New Brunswick";
    static String postalCode = "E3B 1C2";
    static String url = "www.faker.com";
    static String description = faker.backToTheFuture().character();
    static String location = faker.address().city();
    static String tweetText = "Bach to future: " + faker.backToTheFuture().quote();

    static void RefreshFakeVars() {
        fname = faker.name().firstName() + "nya";
        lname = faker.name().lastName();
        email = fname + "." + lname + "@gmail.com";
        username = fname + "." + lname + "123";
        password = faker.bothify("###???###");
        confirmPassword = password;
        phone = "123 123 1234";
        address = faker.address().streetAddress();
        province_byValue = "New Brunswick";
        postalCode = "E3B 1C2";
        url = "www.faker.com";
        description = faker.backToTheFuture().character();
        location = faker.address().city();
        tweetText = "Bach to future: " + faker.backToTheFuture().quote();
    }

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Run registrations tests
        RunRegistrationTests(driver);
        //Run Login Tests
        RunLoginTests(driver);
        //Run Tweet Tests
        RunTweetTests(driver);

        //End of test - close chrome
        driver.close();
    }

    // Method for method all registration tests
    static void RunRegistrationTests(WebDriver driver) {
        /*      Registration Tests      */
        //
        //
        // Run Tests
        //Expected result: Pass
        boolean registrationTest01 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Pass");
        if (registrationTest01) {
            System.out.println("RegistrationTest01: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest01: Test Failed!");
        }

        //Expected result: Fail
        // First Name not provided
        RefreshFakeVars(); // refresh vars
        boolean registrationTest02 = UnitTests.CreateUser(driver, "", lname, email, username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest02) {
            System.out.println("RegistrationTest02: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest02: Test Failed!");
        }

        //Expected result: Fail
        // Last Name not provided
        RefreshFakeVars(); // refresh vars
        boolean registrationTest03 = UnitTests.CreateUser(driver, fname, "", email, username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest03) {
            System.out.println("RegistrationTest03: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest03: Test Failed!");
        }

        //Expected result: Fail
        // Email not provided
        RefreshFakeVars(); // refresh vars
        boolean registrationTest04 = UnitTests.CreateUser(driver, fname, lname, "", username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest04) {
            System.out.println("RegistrationTest04: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest04: Test Failed!");
        }

        /*  BUG */
        //Expected result: Fail
        // Wrong Email Format 
        RefreshFakeVars(); // refresh vars
        boolean registrationTest05 = UnitTests.CreateUser(driver, fname, lname, "notmyemail@gmail", username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest05) {
            System.out.println("RegistrationTest05: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest05: Test Failed!");
        }

        /*  BUG */
        //Expected result: Fail
        // Wrong Email Format 
        RefreshFakeVars(); // refresh vars
        boolean registrationTest06 = UnitTests.CreateUser(driver, fname, lname, "notmyemail@gmail.wayToLongEmailDomainEnding", username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest06) {
            System.out.println("RegistrationTest06: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest06: Test Failed!");
        }

        /*  BUG */
        // Expected result: Fail
        // Duplicate username
        // don't refresh vars
        boolean registrationTest07 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest07) {
            System.out.println("RegistrationTest07: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest07: Test Failed!");
        }

        // Expected result: Fail
        // no username provided
        // don't refresh vars
        boolean registrationTest07_1 = UnitTests.CreateUser(driver, fname, lname, email, "", password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest07_1) {
            System.out.println("RegistrationTest07_1: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest07_1: Test Failed!");
        }

        /*  BUG */
        // Expected result: Fail
        // username value exeeds DB limits 
        RefreshFakeVars(); // refresh vars
        username = faker.bothify("###???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???#########???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???####???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???####???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???####???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???######???#???#");
        boolean registrationTest07_2 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest07_2) {
            System.out.println("RegistrationTest07_2: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest07_2: Test Failed!");
        }

        // Expected result: Fail
        // Password not cofirmed
        RefreshFakeVars(); // refresh vars
        boolean registrationTest08 = UnitTests.CreateUser(driver, fname, lname, email, username, password, "", phone, address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest08) {
            System.out.println("RegistrationTest08: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest08: Test Failed!");
        }

        // Expected result: Pass
        // Testing phone format
        RefreshFakeVars(); // refresh vars
        boolean registrationTest09 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, "1231231234", address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Pass");
        if (registrationTest09) {
            System.out.println("RegistrationTest09: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest09: Test Failed!");
        }

        // Expected result: Pass
        // Testing phone format
        RefreshFakeVars(); // refresh vars
        boolean registrationTest10 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, "(123) 123-1234",
                address, province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Pass");
        if (registrationTest10) {
            System.out.println("RegistrationTest10: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest10: Test Failed!");
        }

        // Expected result: Fail
        // Testing with empty address value
        RefreshFakeVars(); // refresh vars
        boolean registrationTest11 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone,
                "", province_byValue, postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest11) {
            System.out.println("RegistrationTest11: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest11: Test Failed!");
        }

        /*  BUG */
        // Expected result: Fail
        // Testing with province that does not match the postal code
        RefreshFakeVars(); // refresh vars
        boolean registrationTest12 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone,
                address, "Yukon", postalCode, url, description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest12) {
            System.out.println("RegistrationTest12: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest12: Test Failed!");
        }

        // Expected result: Pass
        // Testing postal code in different format
        RefreshFakeVars(); // refresh vars
        boolean registrationTest13 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone,
                address, province_byValue, "E3B1C2", url, description, location);
        System.out.println("Expected result: Pass");
        if (registrationTest13) {
            System.out.println("RegistrationTest13: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest13: Test Failed!");
        }

        /*  BUG */
        // Expected result: Fail
        // Testing with no url provided
        RefreshFakeVars(); // refresh vars
        boolean registrationTest14 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone,
                address, province_byValue, postalCode, "", description, location);
        System.out.println("Expected result: Fail");
        if (registrationTest14) {
            System.out.println("RegistrationTest14: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest14: Test Failed!");
        }

        // Expected result: Fail
        // Testing with no description provided
        RefreshFakeVars(); // refresh vars
        boolean registrationTest15 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone,
                address, province_byValue, postalCode, url, "", location);
        System.out.println("Expected result: Fail");
        if (registrationTest15) {
            System.out.println("RegistrationTest15: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest15: Test Failed!");
        }

        /*  BUG */
        // Expected result: Fail
        // Testing with no location provided
        RefreshFakeVars(); // refresh vars
        boolean registrationTest16 = UnitTests.CreateUser(driver, fname, lname, email, username, password, confirmPassword, phone,
                address, province_byValue, postalCode, url, description, "");
        System.out.println("Expected result: Fail");
        if (registrationTest16) {
            System.out.println("RegistrationTest16: Test Passed!");
        }
        else {
            System.out.println("RegistrationTest16: Test Failed!");
        }
    }

    static void RunLoginTests(WebDriver driver) {

        // Expected result: Fail
        // Username has sql injection
        username = "Update users set first_name=\"f\"";
        password = "asdf";
        boolean loginTest05 = UnitTests.LoginUser(driver, username, password);
        System.out.println("Expected result: Fail");
        if (loginTest05) {
            System.out.println("loginTest05: Test Passed!");
        }
        else {
            System.out.println("loginTest05: Test Failed!");
        }

        // Expected result: Fail
        // Username has an extra space
        username = " NICK";
        password = "asdf";
        boolean loginTest04 = UnitTests.LoginUser(driver, username, password);
        System.out.println("Expected result: Fail");
        if (loginTest04) {
            System.out.println("loginTest04: Test Passed!");
        }
        else {
            System.out.println("loginTest04: Test Failed!");
        }
        // Expected result: Pass
        // Provided valid username and password
        username = "nick";
        password = "asdf";
        boolean loginTest01 = UnitTests.LoginUser(driver, username, password);
        System.out.println("Expected result: Pass");
        if (loginTest01) {
            System.out.println("loginTest01: Test Passed!");
        }
        else {
            System.out.println("loginTest01: Test Failed!");
        }

        // Expected result: Pass
        // Username has one letter uppercase
        username = "nicK";
        password = "asdf";
        boolean loginTest02 = UnitTests.LoginUser(driver, username, password);
        System.out.println("Expected result: Pass");
        if (loginTest02) {
            System.out.println("loginTest02: Test Passed!");
        }
        else {
            System.out.println("loginTest02: Test Failed!");
        }
        // Expected result: Pass
        // Username is all uppercase
        username = "NICK";
        password = "asdf";
        // Turn off the log off for this test as it is the last one
        UnitTests.retry = false;
        boolean loginTest03 = UnitTests.LoginUser(driver, username, password);
        System.out.println("Expected result: Pass");
        if (loginTest03) {
            System.out.println("loginTest03: Test Passed!");
        }
        else {
            System.out.println("loginTest03: Test Failed!");
        }
    }

    static void RunTweetTests(WebDriver driver) {
        // Expected result: Pass
        // Valid tweet text
        boolean tweetTest01 = UnitTests.TweetText(driver, tweetText);
        System.out.println("Expected result: Pass");
        if (tweetTest01) {
            System.out.println("tweetTest01: Test Passed!");
        }
        else {
            System.out.println("tweetTest01: Test Failed!");
        }

        // Expected result: Fail
        // Tweet text too long
        tweetText = BigCatNamesString(faker, 80);
        boolean tweetTest02 = UnitTests.TweetText(driver, tweetText);
        System.out.println("Expected result: Fail");
        if (tweetTest02) {
            System.out.println("tweetTest02: Test Passed!");
        }
        else {
            System.out.println("tweetTest02: Test Failed!");
        }

        // Expected result: Fail
        // Tweet text is 0 characters
        tweetText = "";
        boolean tweetTest03 = UnitTests.TweetText(driver, tweetText);
        System.out.println("Expected result: Fail");
        if (tweetTest03) {
            System.out.println("tweetTest03: Test Passed!");
        }
        else {
            System.out.println("tweetTest03: Test Failed!");
        }
    }

    // Cat name generator - helper method
    static String BigCatNamesString(Faker faker, int limit) { // for testing DB field size limits, generate a string with many cat names
        String x = "Cat Names: ";
        for (int i = 1; i <= limit; i++) {
            x += faker.cat().name() + " ";
        }
        return x;
    }
}
