package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

public class LoginTest extends BaseTest{
    @Test
    public void loginWithValidData() {
        String email = "szybko872@gmail.com";
        String password = "Zxcv1234@";

        String textAlert = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm("test@gmail.com", "Test@123@gmail")
                .getLogInAlert();

        Assert.assertTrue(textAlert.contains("You have been logged in!"));
    }

    @Test
    public void loginWithInvalidData() {

    }
}
