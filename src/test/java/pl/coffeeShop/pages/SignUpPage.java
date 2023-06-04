package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.models.SignUpUserModel;

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

    @FindBy(name="acceptTerms")
    private  WebElement acceptTermCheckbox;
    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElement btnSignUp;

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public HomePage fillFormWithValidData(SignUpUserModel user) {
        firstNameInput.click();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        confirmPasswordInput.sendKeys(user.getConfirmPassword());
        acceptTermCheckbox.click();
        btnSignUp.click();

        return new HomePage(driver);
    }
}
