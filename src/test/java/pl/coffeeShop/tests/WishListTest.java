package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

public class WishListTest extends BaseTest {

    @Test
    public void viewProductTest() {
        String productNameExpected = "Crema e Aroma, 1 kg";

        String productName = new HomePage(driver)
                .openProductsPage()
                .addProductWishList("wishlistId3")
                .openWishlistPage()
                .clickOnViewBtn()
                .getProductName(productNameExpected);

        Assert.assertEquals(productName, productNameExpected);
    }

    @Test
    public void deleteProductTest() {
        int wishlistSizeExpected = 0;

        int wishlistSize = new HomePage(driver)
                .openProductsPage()
                .addProductWishList("wishlistId3")
                .openWishlistPage()
                .clickOnDeleteBtn()
                .getWishlist();

        Assert.assertEquals(wishlistSize, wishlistSizeExpected);
    }

    @Test
    public void addMultipleProductsWishlistTest() {
        int wishlistSizeExpected = 3;

        int wishlistSize = new HomePage(driver)
                .openProductsPage()
                .addProductWishList("wishlistId3")
                .addProductWishList("wishlistId2")
                .addProductWishList("wishlistId1")
                .openWishlistPage()
                .getWishlist();

        Assert.assertEquals(wishlistSize, wishlistSizeExpected);
    }
}
