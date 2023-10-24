package pl.coffeeShop.pages;

import com.beust.ah.A;
import org.openqa.selenium.*;
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


    @FindBy(xpath = "//header[text()='We care about you']")
    private WebElement careAbout;

    @FindBy(className = "CartList_SingleProduct__2oN4t")
    private List<WebElement> cartProducts;

    @FindBy(id = "cartBtnOpen132")
    private WebElement btnCart;

    @FindBy(xpath = "//span[contains(text(), 'items)')]")
    private WebElement cartSize;
    WebDriver driver;
    JavascriptExecutor js;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
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

    public HomePage onClickCart() {
        SeleniumHelper.handleJavaExecutor(driver, btnCart);
        return this;
    }

    public int getCartSize() {
        try {
            WebElement webElement = driver.findElement(By.xpath("//span[contains(text(), 'items)')]"));
            return Character.getNumericValue(webElement.getText().charAt(1));
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
    public Integer getCartProducts() {
        return cartProducts.size();
    }

    public String getHeaderText() {
        return headerTextAboutUs.getText();
    }
}
