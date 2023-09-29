package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {
    @FindBy(xpath = "//h1[text()='Recent posts']")
    private  WebElement text;

    WebDriver driver;

    public BlogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getText() {
        return text.getText();
    }
}
