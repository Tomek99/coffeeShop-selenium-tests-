package pl.coffeeShop.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.DriverFactory;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

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

    @FindBy(xpath = "//button[text()='Sign up']")
    private List<WebElement> aSignUp;

    @FindBy(xpath = "//a[@id='userNavigationBtn0']")
    private WebElement userNavigationBtn;

    @FindBy(xpath = "//div[text()='You have been logged in!']")
    private WebElement logInAlert;

    @FindBy(xpath = "//header[text()='about us']")
    private WebElement headerTextAboutUs;

    @FindBy(xpath = "//button[text()='Log in']")
    List<WebElement> aLogin;


    @FindBy(xpath = "//header[text()='We care about you']")
    private WebElement careAbout;

    @FindBy(className = "CartList_SingleProduct__2oN4t")
    private List<WebElement> cartProducts;

    @FindBy(id = "cartBtnOpen132")
    private WebElement btnCart;

    @FindBy(xpath = "//span[contains(text(), 'items)')]")
    private WebElement cartSize;

    @FindBy(id = "bs-search")
    private WebElement bsSearch;

    @FindBy(id = "search-form")
    private WebElement searchInput;

    @FindBy(id = "btn-close-searcher")
    private WebElement closeSearcherBtn;

    @FindBy(xpath = ("//div[@class='SearchEngine_flexRowTemplate__L0kWa']/div"))
    private List<WebElement> foundElementsSearcher;

    @FindBy (xpath = "//header[text()='fresh coffee in the morning']")
            private WebElement freshCoffeeInTheMorningTitle;

    WebDriver driver;
    JavascriptExecutor js;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }


    public HomePage openHomePage() {
        DriverFactory.getDriver().get("http://localhost:3000/");
        return this;
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

    public String getAlertMessage() {
        String alertXPath = "//div[@role='alert']/div[2]";

        SeleniumHelper.waitForVisibility(driver, By.xpath(alertXPath));
        return driver.findElement(By.xpath(alertXPath)).getText();
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

    public HomePage clickOnCart() {
        SeleniumHelper.handleJavaExecutor(driver, btnCart);
        return this;
    }

    public HomePage clickOnSearcherBsBtn() {
        bsSearch.click();

        return this;
    }

    public HomePage fillSearcherInput(String inputData) {
        searchInput.sendKeys(inputData);

        return this;
    }

    public HomePage clearSearcherInput() {
        searchInput.clear();
        searchInput.sendKeys(" ");
        searchInput.clear();

        return this;
    }

    public List<String> searchElements() {
        return foundElementsSearcher
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());


    }

    public ProductDetailsPage clickOnProduct(int id) {
        foundElementsSearcher.get(id).click();

        return new ProductDetailsPage(driver);
    }

    public WebElement clickOnCloseSearcherBtn() {
        closeSearcherBtn.click();

        return closeSearcherBtn;
    }

    public int getCartSize() {
        By cartQuantityWebElement = By.xpath("//span[@data-testid='cartQuantity']");

        try {
            SeleniumHelper.waitForVisibility(driver, cartQuantityWebElement);
            String text = driver.findElement(cartQuantityWebElement).getText();
            return Integer.parseInt(text);

        } catch (NoSuchElementException | NumberFormatException | TimeoutException e) {
            return 0;
        }
    }


    public Integer getCartProducts() {
        return cartProducts.size();
    }

    public String getHeaderText() {
        return headerTextAboutUs.getText();
    }

    public String getTitleFreshCoffeeInTheMorning() {
        return freshCoffeeInTheMorningTitle.getText().toLowerCase();
    }


}
