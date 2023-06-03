package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//a[text()='Contact' and @class='NavListElement_navLink__JIc6z']")
    private WebElement aContact;

    WebDriver driver;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ContactPage openContactPage() {
        aContact.click();

        return new ContactPage(driver);
    }
}
