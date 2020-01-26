package qa_bitter_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElements {

    //      Login Page Elements
    static WebElement txtUsernameLogin(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"username\"]")); //NOTE: XPath not fullXPath

        return element;
    }

    static WebElement txtPasswordLogin(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        return element;
    }

    static WebElement btnLogin(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"button\"]"));
        return element;
    }

    //      Sign up Elements
    static WebElement txtFirstnameSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        return element;
    }

    static WebElement txtLastNameSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
        return element;
    }

    static WebElement txtEmailSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        return element;
    }

    static WebElement txtUserNameSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        return element;
    }

    static WebElement txtPasswordSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        return element;
    }

    static WebElement txtPasswordConfirmSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"confirm\"]"));
        return element;
    }

    static WebElement txtPhoneSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
        return element;
    }

    static WebElement txtAddressSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        return element;
    }

    static Select ddlProvinceSignup(WebDriver driver) {
        Select element = new Select(driver.findElement(By.xpath("//*[@id=\"province\"]")));// This is a select object
        return element;
    }

    static WebElement txtPostalCodeSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"postalCode\"]"));
        return element;
    }

    static WebElement txtURLSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"url\"]"));
        return element;
    }

    static WebElement txtDescriptionSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"desc\"]"));
        return element;
    }

    static WebElement txtLocationSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"location\"]"));
        return element;
    }

    static WebElement btnRegisterSignup(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"button\"]"));
        return element;
    }

    //  Index Page Elements
    static WebElement txtTweetIndex(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"myTweet\"]"));
        return element;
    }

    static WebElement btnSendTweetIndex(WebDriver driver) {
        WebElement element = driver.findElement(By.id("button"));
        return element;
    }

}
