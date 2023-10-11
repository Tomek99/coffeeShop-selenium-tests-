package pl.coffeeShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.List;

public class ProductsPage {
    @FindBy(className = "LatestProduct_LatestProduct__2nlVY")
    private List<WebElement> listOfProducts;
    @FindBy(xpath = "//li/a[text()='1']")
    private WebElement btnOne;
    @FindBy(xpath = "//li/a[text()='2']")
    private WebElement btnTwo;
    @FindBy(xpath = "//li/a[text()='Next ']")
    private WebElement btnNext;

    @FindBy(xpath = "//a[@aria-label='Previous page']")
    private WebElement btnArrowLeft;


    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;


    }

    public ProductsPage onClickBtnOne() {
        SeleniumHelper.handleJavaExecutor(driver, btnOne);
        return this;
    }

    public ProductsPage onClickBtnTwo() {
        SeleniumHelper.handleJavaExecutor(driver, btnTwo);
        return this;
    }

    public ProductsPage onClickBtnNext() {
        SeleniumHelper.handleJavaExecutor(driver, btnNext);
        return this;
    }

    public ProductsPage onClickBtnArrowLeft() {
      SeleniumHelper.handleJavaExecutor(driver, btnArrowLeft);
      return this;
    }


    public int getProducts() {
        return listOfProducts.size();
    }
}
