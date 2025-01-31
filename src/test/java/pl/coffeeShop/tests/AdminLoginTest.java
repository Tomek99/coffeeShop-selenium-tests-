package pl.coffeeShop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.AdminLoginPage;

import java.time.Duration;
import java.util.List;

public class AdminLoginTest extends BaseAdminPanelTest {
    @Test
    public void loginToAdminPanelWithValidDataTest() {
        String adminLogin = "admin1";
        String adminPassword = "Nimda1";
        String expectedText = "Welcome to the admin panel build-in user!";

        String foundText = new AdminLoginPage(driver)
                .fillAdminLoginInput(adminLogin)
                .fillAdminPasswordInput(adminPassword)
                .clickOnAdminLoginValidBtn()
                .welcomeAdminPanelText();

        Assert.assertEquals(foundText, expectedText);


    }
    @Test
    public void loginWithEmptyFormTest() {
        String adminLogin = "";
        String adminPassword = "";

        List<String> errors = new AdminLoginPage(driver)
                .fillAdminLoginInput(adminLogin)
                .fillAdminPasswordInput(adminPassword)
                .clickOnAdminLoginInvalidBtn()
                .getErrors();
        Assert.assertEquals(errors.size(), 2);
    }
    @Test
    public void loginWithIncorrectLoginTest() {
        String adminLogin = "admin12";
        String adminPassword = "Nimda1";
        String error = "Invalid data, try again...";


        String foundError = new AdminLoginPage(driver)
                .fillAdminLoginInput(adminLogin)
                .fillAdminPasswordInput(adminPassword)
                .clickOnAdminLoginInvalidBtn()
                .getError();

        Assert.assertEquals(foundError, error);
    }
    @Test
    public void loginWithIncorrectPasswordTest() {
        String adminLogin = "admin1";
        String adminPassword = "Nimda12";
        String error = "Invalid data, try again...";

        String foundError = new AdminLoginPage(driver)
                .fillAdminLoginInput(adminLogin)
                .fillAdminPasswordInput(adminPassword)
                .clickOnAdminLoginInvalidBtn()
                .getError();

        Assert.assertEquals(foundError,  error);
    }
    @Test
    public void returnToHomePage() {
        String expectedText = "fresh coffee in the morning";

        String foundText = new AdminLoginPage(driver).clickOnReturnHomeBtn().getTitleFreshCoffeeInTheMorning().toLowerCase();
        Assert.assertEquals(foundText, expectedText);
    }
}
