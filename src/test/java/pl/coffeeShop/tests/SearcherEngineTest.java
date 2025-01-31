package pl.coffeeShop.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

import java.util.List;

public class SearcherEngineTest extends BaseTest {

    @Test
    public void enterInvalidDataTest() {
        String data = "coffe";

        List<String> foundElements = new HomePage(driver)
                .clickOnSearcherBsBtn()
                .fillSearcherInput(data)
                .searchElements();

        Assert.assertTrue(foundElements.contains("No results"));

    }

    @Test
    public void enterValidDataTest() {
        String data = "caffe";
        int numberExpected = 4;

        List<String> foundElements = new HomePage(driver)
                .clickOnSearcherBsBtn()
                .fillSearcherInput(data)
                .searchElements();

        Assert.assertEquals(foundElements.size(), numberExpected);
    }

    @Test
    public void enterAndDeleteDataTest() {
        String data = "caffe";
        int numberExpected = 0;

        List<String> foundElements = new HomePage(driver)
                .clickOnSearcherBsBtn()
                .fillSearcherInput(data)
                .clearSearcherInput()
                .searchElements();

        Assert.assertEquals(foundElements.size(), numberExpected);
    }

    @Test
    public void clickOnSearchedProductTest() {
        String data = "caffe";
        String productNameExpected = "Caffe Crema Classico, 1 kg";

        String productName = new HomePage(driver)
                .clickOnSearcherBsBtn()
                .fillSearcherInput(data)
                .clickOnProduct(0)
                .getProductName(productNameExpected);


        Assert.assertEquals(productName, productNameExpected);
    }

    @Test
    public void clickOnCloseBtnTest() {
        String data = "caffe";

         WebElement closeSearcherBtn = new HomePage(driver)
                .clickOnSearcherBsBtn()
                .fillSearcherInput(data)
                .clearSearcherInput()
                .clickOnCloseSearcherBtn();

        Assert.assertNotNull(closeSearcherBtn, "Exist");

    }


}
