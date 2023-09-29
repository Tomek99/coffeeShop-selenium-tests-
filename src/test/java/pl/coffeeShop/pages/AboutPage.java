package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
    @FindBy(xpath = "//header[text()='Our company']")
    private WebElement header;


    WebDriver driver;


    public AboutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public String getHeaderText() {
        return header.getText();
    }



}
