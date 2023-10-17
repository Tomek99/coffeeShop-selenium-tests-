package pl.coffeeShop.tests;

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
                .onClickCart()
                .getCartProducts();

        Assert.assertEquals(numberOfProducts, 1);
    }

    @Test
    public void addTwoProductsTest() {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addProductsWithoutDuplicateCart(2)
                .onClickCart()
                .getCartProducts();

        Assert.assertEquals(numberOfProducts, 2);
    }

    @Test
    public void addMultipleProductsTest() {
        int randomNumberOfProducts = new Random().nextInt(10) + 1;

        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addProductsWithoutDuplicateCart(randomNumberOfProducts)
                .onClickCart()
                .getCartProducts();

        Assert.assertEquals(numberOfProducts, randomNumberOfProducts);
    }

    @Test
    public void addDuplicateProductsTest() throws InterruptedException {
        int randomNumberOfProducts = new Random().nextInt(10) + 1;
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addDuplicateProductsCart(randomNumberOfProducts)
                .onClickCart()
                .getCartSize();

        Assert.assertEquals(randomNumberOfProducts, numberOfProducts);

    }

    @Test
    public void emptyCartTest() {
        int emptyCart = 0;

        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .addDuplicateProductsCart(emptyCart)
                .onClickCart()
                .getCartSize();

        Assert.assertEquals(emptyCart, numberOfProducts);
    }

}
