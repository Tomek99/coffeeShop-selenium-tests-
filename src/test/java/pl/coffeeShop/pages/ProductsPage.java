package pl.coffeeShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

    public HomePage addProductsWithoutDuplicateCart(int numberOfProducts) {
        Set<Integer> uniqueRandomNumbers = generateUniqueRandomNumbers(numberOfProducts);

        for (int number : uniqueRandomNumbers) {
            String idProduct = "cartFillId" + number;
            WebElement cartBtn = driver.findElement(By.id(idProduct));
            SeleniumHelper.handleJavaExecutor(driver, cartBtn);
        }

        return new HomePage(driver);
    }

    public HomePage addDuplicateProductsCart(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            int randomProductTwice = new Random().nextInt(2);

            String idProduct = "cartFillId" + randomProductTwice;
            WebElement cartBtn = driver.findElement(By.id(idProduct));
            SeleniumHelper.handleJavaExecutor(driver, cartBtn);
        }

        return new HomePage(driver);
    }

    private Set<Integer> generateUniqueRandomNumbers(int size) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < size) {
            int randomNumber = random.nextInt(size);
            uniqueNumbers.add(randomNumber);
        }
        return uniqueNumbers;
    }


    public int getProducts() {
        return listOfProducts.size();
    }


}
