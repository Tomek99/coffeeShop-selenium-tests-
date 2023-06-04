package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.models.SignUpUserModel;
import pl.coffeeShop.pages.HomePage;

import java.util.Random;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpWithValidData() {
        int number = (int) (Math.random()*1000);

        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Tomasz");
        user.setLastName("TEST");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String textAlert = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .getLogInAlert();

        Assert.assertEquals(textAlert, "You have been logged in!");
    }
}
