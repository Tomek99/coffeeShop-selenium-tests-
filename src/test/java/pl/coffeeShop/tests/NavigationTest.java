package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

public class NavigationTest extends BaseTest {
    @Test
    public void openProductsPageTest() {
        int amountProducts  = new HomePage(driver)
                .openProductsPage()
                .getProducts();

        Assert.assertEquals(amountProducts, 12);
    }


    @Test
    public void openAboutPageTest() {
        String headerText = new HomePage(driver)
                .openAboutPage()
                .getHeaderText();

        Assert.assertEquals(headerText, "OUR COMPANY");
    }

    @Test
    public void openContactPageTest() {
        String headerText = new HomePage(driver)
                .openContactPage()
                .getHeaderText();

        Assert.assertEquals(headerText, "CONTACT US");
    }

    @Test
    public void openBlogPageTest() {
        String text = new HomePage(driver)
                .openBlogPage()
                .getText();

        Assert.assertEquals(text, "Recent posts");

    }

    @Test
    public void isHomePageTest() {
        String headerText = new HomePage(driver)
                .getHeaderText();

       Assert.assertEquals(headerText, "ABOUT US");
    }
}
