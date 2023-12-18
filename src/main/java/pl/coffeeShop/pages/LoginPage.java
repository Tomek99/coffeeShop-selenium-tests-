package pl.coffeeShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage {
    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginBtn;

    @FindBy(className = "LogIn_error__HhaPV")
    WebElement error;

    @FindBy(className = "ErrMessage_errorText__1OrwW")
    List<WebElement> errors;

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    public LoginPage fillLoginForm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);


        return this;
    }

    public String handleCorrectData() {
        loginBtn.click();

        return SeleniumHelper.getTextAlert(driver,
                By.xpath("//div[text()='You have been logged in!']"));
    }

    public LoginPage handleIncorrectData() {
        loginBtn.click();
        return this;
    }

    public String getError() {
        return error.getText();
    }

    public List<String> getErrors()  {
        return  errors.stream()
                .map(WebElement::getText)
                .toList().stream()
                .map(String::trim)
                .filter(trim -> !trim
                        .isEmpty())
                .collect(Collectors.toList());
    }

}
