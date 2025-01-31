package pl.coffeeShop.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

import java.util.Random;

public class ProductCartTest extends BaseTest {

    @Test
    public void addOneProductTest() {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addProductsWithoutDuplicateCart(1)
                .clickOnCart()
                .getCartProducts();

        Assert.assertEquals(numberOfProducts, 1);
    }

    @Test
    public void addTwoProductsTest() {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addProductsWithoutDuplicateCart(2)
                .clickOnCart()
                .getCartProducts();

        Assert.assertEquals(numberOfProducts, 2);
    }

    @Test
    public void addMultipleProductsTest() {
        int randomNumberOfProducts = new Random().nextInt(10) + 1;

        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addProductsWithoutDuplicateCart(randomNumberOfProducts)
                .clickOnCart()
                .getCartProducts();

        Assert.assertEquals(numberOfProducts, randomNumberOfProducts);
    }

    @Test
    public void addDuplicateProductsTest() throws InterruptedException {
        int randomNumberOfProducts = new Random().nextInt(10) + 1;
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addDuplicateProductsCart(randomNumberOfProducts)
                .clickOnCart()
                .getCartSize();

        Assert.assertEquals(numberOfProducts, randomNumberOfProducts);



    }

    @Test
    public void emptyCartTest() {
        int emptyCart = 0;

        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addDuplicateProductsCart(emptyCart)
                .clickOnCart()
                .getCartSize();

        Assert.assertEquals(emptyCart, numberOfProducts);
    }

}
