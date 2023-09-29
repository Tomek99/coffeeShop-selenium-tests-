package pl.coffeeShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    @FindBy(className = "LatestProduct_LatestProduct__2nlVY")
    private List<WebElement> listOfProducts;

    WebDriver driver;
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    public  int getProducts() {
        return  listOfProducts.size();
    }
}
