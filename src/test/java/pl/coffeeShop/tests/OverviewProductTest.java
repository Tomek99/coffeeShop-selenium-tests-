package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

public class OverviewProductTest extends BaseTest {


    @Test
    public void visitProductDetailsByBtnTest() {
        String productNameExpected = "Caffe Crema Classico, 1 kg";
        String productId = "showProductId0";

        String productName = new HomePage(driver)
                .openProductsPage()
                .openProductDetailsPage(productId)
                .getProductName(productNameExpected);

        Assert.assertEquals(productName, productNameExpected);
    }

    @Test
    public void visitProductDetailsByTextTest() {
        String productNameExpected = "Caffe Crema Classico, 1 kg";

        String productName = new HomePage(driver)
                .openProductsPage()
                .openProductDetailsPageByText(productNameExpected)
                .getProductName(productNameExpected);

        Assert.assertEquals(productName, productNameExpected);
    }

    @Test
    public void addProductCartTest() {
        String productId = "cartFillId1";
        String productQuantityExpected = "1";

        String productQuantity = new HomePage(driver)
                .openProductsPage()
                .addProductCart(productId)
                .getProductsQuantityInCart();

        Assert.assertEquals(productQuantity, productQuantityExpected);
    }

    @Test
    public void addProductWishListTest()  {
        String wishBtnId = "wishlistId2";
        String messageTextExpected = "Product added to wish list!";

        String messageText = new HomePage(driver)
                .openProductsPage()
                .addProductWishList(wishBtnId)
                .getMessageText();


        Assert.assertEquals(messageText, messageTextExpected);
    }


}
