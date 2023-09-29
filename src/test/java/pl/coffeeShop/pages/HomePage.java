package pl.coffeeShop.pages;

import com.beust.ah.A;
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

    @FindBy(xpath = "//a[text()='Home' and @class='NavListElement_navLink__JIc6z']")
    private WebElement aHome;

    @FindBy(xpath = "//a[text()='Products' and @class='NavListElement_navLink__JIc6z']")
    private WebElement aProducts;

    @FindBy(xpath = "//a[text()='About' and @class='NavListElement_navLink__JIc6z']")
    private WebElement aAbout;

    @FindBy(xpath = "//a[text()='Blog' and @class='NavListElement_navLink__JIc6z']")
   private WebElement aBlog;

    @FindBy(xpath = "//a[text()='Sign up']")
    private List<WebElement> aSignUp;

    @FindBy(xpath = "//a[@id='userNavigationBtn0']")
    private WebElement userNavigationBtn;

    @FindBy(xpath = "//div[text()='You have been logged in!']")
    private WebElement logInAlert;

    @FindBy(xpath = "//header[text()='about us']")
    private WebElement headerTextAboutUs;

    @FindBy(xpath = "//a[text()='Log in']")
    List<WebElement> aLogin;


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

    public LoginPage openLoginPage() {
        Actions action = new Actions(driver);
        action.moveToElement(userNavigationBtn).perform();
        aLogin.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);

        return new LoginPage(driver);
    }

    public ProductsPage openProductsPage() {
        aProducts.click();

        return new ProductsPage(driver);
    }

    public AboutPage openAboutPage() {
        aAbout.click();

        return new AboutPage(driver);
    }

    public BlogPage openBlogPage() {
        aBlog.click();

        return new BlogPage(driver);
    }

    public String getHeaderText() {
        return headerTextAboutUs.getText();
    }
}
