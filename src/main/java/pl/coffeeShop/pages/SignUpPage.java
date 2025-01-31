package pl.coffeeShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.models.SignUpUserModel;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage {
    @FindBy(name = "firstName")
    private WebElement firstNameInput;
    @FindBy(name = "lastName")
    private WebElement lastNameInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "passwordConfirmation")
    private WebElement confirmPasswordInput;

    @FindBy(name = "acceptTerms")
    private WebElement acceptTermCheckbox;
    @FindBy(xpath = "//button[text()='Sign up']")
    private List<WebElement> btnSignUp;

    @FindBy(className = "ErrMessage_errorText__1OrwW")
    private List<WebElement> errors;

    @FindBy(xpath = "//input[@name='firstName']")
    private List<WebElement> userInputSize;
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public SignUpPage fillFormWithValidData(SignUpUserModel user) {
        firstNameInput.click();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        confirmPasswordInput.sendKeys(user.getConfirmPassword());
        return this;
    }

    public SignUpPage clickOnAcceptTermsCheckbox() {
        acceptTermCheckbox.click();
        return this;
    }

    public HomePage clickOnSignUpBtn() {
        btnSignUp.get(1).click();
        return new HomePage(driver);
    }

    public SignUpPage handleSignUpBtnInvalidData() {
        btnSignUp.get(1).click();
        return this;
    }

    public List<String> getErrors() {
        SeleniumHelper.waitForVisibility(driver, By.className("ErrMessage_errorText__1OrwW"));
        return errors.stream()
                .map(WebElement::getText)
                .toList().stream()
                .map(String::trim)
                .filter(trim -> !trim
                        .isEmpty())
                .collect(Collectors.toList());
    }

    public String getError(String path) {
        String error = driver.findElement(By.xpath(String.format("//div[text()='%s']", path))).getText();
        return error;

    }

    public int getUsernameInputSize() {
        return userInputSize.size();
    }


}
