package qa_bitter_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class UnitTests {

    private static final int waitTimeMS = 1000; // 1 second
    public static boolean retry = true; // by default retry loggin in by loggin out first. Variable used in LoginUser function

    public static boolean CreateUser(WebDriver driver, String fname, String lname, String email, String username,
            String password, String confirmPassword, String phone, String address, String province_byValue, String postalCode,
            String url, String description, String location) {

        // Access signup page
        driver.get("http://10.10.0.30/qa/timk/signup.php"); //   CHANGE ME LATER TO THE CORRECT URL
        //driver.get("http://timbitter/signup.php"); //   CHANGE ME LATER TO THE CORRECT URL

        // Wait
        Sleep(waitTimeMS);

        // Create WebElements for registration page
        WebElement txtFirstnameSignup = WebElements.txtFirstnameSignup(driver);
        WebElement txtLastNameSignup = WebElements.txtLastNameSignup(driver);
        WebElement txtEmailSignup = WebElements.txtEmailSignup(driver);
        WebElement txtUserNameSignup = WebElements.txtUserNameSignup(driver);
        WebElement txtPasswordSignup = WebElements.txtPasswordSignup(driver);
        WebElement txtPasswordConfirmSignup = WebElements.txtPasswordConfirmSignup(driver);
        WebElement txtPhoneSignup = WebElements.txtPhoneSignup(driver);
        WebElement txtAddressSignup = WebElements.txtAddressSignup(driver);
        Select ddlProvinceSignup = (Select) WebElements.ddlProvinceSignup(driver);
        WebElement txtPostalCodeSignup = WebElements.txtPostalCodeSignup(driver);
        WebElement txtURLSignup = WebElements.txtURLSignup(driver);
        WebElement txtDescriptionSignup = WebElements.txtDescriptionSignup(driver);
        WebElement txtLocationSignup = WebElements.txtLocationSignup(driver);
        WebElement btnRegisterSignup = WebElements.btnRegisterSignup(driver);

        // Send Input to registration fields
        txtFirstnameSignup.sendKeys(fname);
        txtLastNameSignup.sendKeys(lname);
        txtEmailSignup.sendKeys(email);
        txtUserNameSignup.sendKeys(username);
        txtPasswordSignup.sendKeys(password);
        txtPasswordConfirmSignup.sendKeys(confirmPassword);
        txtPhoneSignup.sendKeys(phone);
        txtAddressSignup.sendKeys(address);

        ddlProvinceSignup.selectByValue(province_byValue);// Select Object

        txtPostalCodeSignup.sendKeys(postalCode);
        txtURLSignup.sendKeys(url);
        txtDescriptionSignup.sendKeys(description);
        txtLocationSignup.sendKeys(location);

        // Click the Registration Button
        btnRegisterSignup.click();

        // Sleep 
        Sleep(waitTimeMS);

        //URL Comparison
        String goodURL = "http://10.10.0.30/qa/timk/Login.php"; 
        //String goodURL = "http://timbitter/Login.php";
        String CurrentURL = driver.getCurrentUrl();

        // Compare the two URLS, return if test is a SUCCESS or FAILURE
        if (CurrentURL.contains(goodURL)) {

            // Wait a bit
            Sleep();

            return true;
        }
        else {
            return false;
        }

    }

    public static boolean LoginUser(WebDriver driver, String username, String password) {
        try {

            // Access signup page
            driver.get("http://10.10.0.30/qa/timk/Login.php"); //   CHANGE ME LATER TO THE CORRECT URL
            //driver.get("http://timbitter/Login.php"); //   CHANGE ME LATER TO THE CORRECT URL

            // Wait
            Sleep(waitTimeMS);

            // Create WebElements for login page
            WebElement txtUsernameLogin = WebElements.txtUsernameLogin(driver);
            WebElement txtPasswordLogin = WebElements.txtPasswordLogin(driver);
            WebElement btnLogin = WebElements.btnLogin(driver);

            // Send Input to login fields
            txtUsernameLogin.sendKeys(username);
            txtPasswordLogin.sendKeys(password);

            //Click the login BTN
            btnLogin.click();

            // Sleep 
            Sleep(waitTimeMS);
            Sleep();

            //URL Comparison
            String goodURL = "http://10.10.0.30/qa/timk/index.php"; 
            //String goodURL = "http://timbitter/index.php";
            String CurrentURL = driver.getCurrentUrl();

            // Compare the two URLS, return if test is a SUCCESS or FAILURE
            if (CurrentURL.contains(goodURL)) {
                // Wait a bit
                Sleep();

                if (retry) { // check ti see if test nedds to be run again
                    driver.get("http://10.10.0.30/qa/timk/logout.php");
                    Sleep(1000); // wait for page to load
                }
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    public static boolean TweetText(WebDriver driver, String tweet) {
        try {
            Sleep();
            if (driver.getCurrentUrl().contains("http://10.10.0.30/qa/timk/index.php")) {
                // Create WebElements for index page
                WebElement txtTweetIndex = WebElements.txtTweetIndex(driver);
                WebElement btnSendTweetIndex = WebElements.btnSendTweetIndex(driver);

                txtTweetIndex.click(); // focus on tweet input
                Sleep();
                txtTweetIndex.sendKeys(tweet);  // Send input to tweet field
                Sleep(2000);    // Wait
                btnSendTweetIndex.click(); //Click the send tweet btn twice - kuz why not? Don't forget to sleep in beetween
                Sleep();
                btnSendTweetIndex.click();
                Sleep(1000);
                driver.get("http://10.10.0.30/qa/timk/index.php"); // refresh the page so that the last tweet can be found in source page
                Sleep(400);    // sleep another bit, you ned a 100 millisecods nap
                return driver.getPageSource().contains(tweet);
            }
            return false;
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            return false;
        }
    }

// Helper method - Put Thread to sleep for selected ammount of time
    private static void Sleep(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

// Overloading the helper method
    private static void Sleep() {
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
