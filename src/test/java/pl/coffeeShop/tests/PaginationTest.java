package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

public class PaginationTest extends BaseTest {
    private final int NUMBER_OF_EXPECTED_PRODUCTS_PAGE_ONE = 12;
    private final int NUMBER_OF_EXPECTED_PRODUCTS_PAGE_TWO = 10;



    @Test
    public void visitPageOneBtnOneTest()  {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .clickOnBtnTwo()
                .clickOnBtnOne()
                .getProducts();

        Assert.assertEquals(numberOfProducts, NUMBER_OF_EXPECTED_PRODUCTS_PAGE_ONE);
    }

    @Test
    public void visitPageTwoBtnTwoTest()  {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .clickOnBtnTwo()
                .getProducts();

        Assert.assertEquals(numberOfProducts, NUMBER_OF_EXPECTED_PRODUCTS_PAGE_TWO);

    }

    @Test
    public void visitPageTwoBtnNextTest()  {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .clickOnBtnNext()
                .getProducts();

        Assert.assertEquals(numberOfProducts, NUMBER_OF_EXPECTED_PRODUCTS_PAGE_TWO);
    }

    @Test
    public void visitPageOneBtnArrowText() {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .clickOnBtnNext()
                .clickOnBtnArrowLeft()
                .getProducts();

        Assert.assertEquals(numberOfProducts, NUMBER_OF_EXPECTED_PRODUCTS_PAGE_ONE);
    }


    @Test
    public void handleAllButtons() {
        int numberOfProducts = new HomePage(driver)
                .openProductsPage()
                .clickOnBtnOne()
                .clickOnBtnTwo()
                .clickOnBtnArrowLeft()
                .clickOnBtnNext()
                .getProducts();

        Assert.assertEquals(numberOfProducts, NUMBER_OF_EXPECTED_PRODUCTS_PAGE_TWO);
    }

}
