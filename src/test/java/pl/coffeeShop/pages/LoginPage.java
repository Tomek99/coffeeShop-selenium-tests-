package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginBtn;

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    public HomePage fillLoginForm(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginBtn.click();

        return new HomePage(driver);
    }

}
