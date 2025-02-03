package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.DriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class AdminLoginPage {
    @FindBy(name = "adminLogin")
    private WebElement adminLoginInput;

    @FindBy(name = "adminPassword")
    private  WebElement adminPasswordInput;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement adminLoginBtn;

    @FindBy(xpath = "//button[text()='Return Home']")
    private  WebElement returnHomeBtn;

    @FindBy(className = "ErrMessage_errorText__1OrwW")
    private List<WebElement> foundErrors;

    @FindBy(xpath = "//p[contains(text(), 'Invalid data, try again...')]")
    private  WebElement invalidLoginOrPassword;

    WebDriver driver;

    public AdminLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openAdminLoginPage() {
        driver.get("http://localhost:3000/admin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public AdminLoginPage fillAdminLoginInput(String login) {
        adminLoginInput.sendKeys(login);
        return this;
    }

    public AdminLoginPage fillAdminPasswordInput(String password) {
        adminPasswordInput.sendKeys(password);
        return this;
    }

    public HomePage clickOnReturnHomeBtn() {
        returnHomeBtn.click();
        return new HomePage(driver);
    }

    public AdminLoginPage clickOnAdminLoginInvalidBtn() {
        adminLoginBtn.click();
        return this;
    }

    public AdminPanelPage clickOnAdminLoginValidBtn() {
        adminLoginBtn.click();
        return new AdminPanelPage(driver);
    }

    public List<String> getErrors() {
        return foundErrors.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(trim -> !trim
                        .isEmpty())
                .collect(Collectors.toList());
    }

    public String getError() {
        return invalidLoginOrPassword.getText();
    }
}
