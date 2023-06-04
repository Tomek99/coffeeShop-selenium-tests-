package pl.coffeeShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.List;

public class HomePage {
    @FindBy(xpath = "//a[text()='Contact' and @class='NavListElement_navLink__JIc6z']")
    private WebElement aContact;

    @FindBy(xpath = "//a[text()='Sign up']")
    private List<WebElement> aSignUp;

    @FindBy(xpath = "//a[@id='userNavigationBtn0']")
    private WebElement userNavigationBtn;

    @FindBy(xpath = "//div[text()='You have been logged in!']")
    private WebElement logInAlert;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ContactPage openContactPage() {
        aContact.click();

        return new ContactPage(driver);
    }

    public SignUpPage openSignUpPage() {
        Actions action = new Actions(driver);
        action.moveToElement(userNavigationBtn).perform();
        aSignUp.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);

        return new SignUpPage(driver);
    }

    public String getLogInAlert() {
        SeleniumHelper.waitForVisibility(driver, By.xpath("//div[text()='You have been logged in!']"));
        return logInAlert.getText();
    }
}
