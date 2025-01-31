package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage {
    @FindBy(xpath = "//h1")
    WebElement welcomeToTheAdminPanelText;

    WebDriver driver;
    AdminPanelPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String welcomeAdminPanelText() {
        return welcomeToTheAdminPanelText.getText();
    }
}
