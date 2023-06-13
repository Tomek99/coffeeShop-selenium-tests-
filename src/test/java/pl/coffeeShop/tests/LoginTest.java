package pl.coffeeShop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.List;

public class LoginTest extends BaseTest{
    @Test
    public void loginWithValidData() {
        String email = "test@gmail.com";
        String password = "Test@123@gmail";

         String textAlert = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleCorrectData();

        Assert.assertTrue(textAlert.contains("You have been logged in!"));
    }

    @Test
    public void loginWithInvalidEmail() {
        String email = "testg@gmail.com";
        String password = "Test@123@gmail";

        String textError = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getError();

        Assert.assertEquals(textError, "Wrong password or email");
    }

    @Test
    public void loginWithInvalidPassword() {
        String email = "test@gmail.com";
        String password = "Test@123@gmailWRONG";

        String textError = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getError();

        Assert.assertEquals(textError, "Wrong password or email");
    }

    @Test
    public void loginWithEmailOnly() {
        String email = "test@gmail.com";
        String password = "";

        List<String> textErrors = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getErrors();

        Assert.assertTrue(textErrors.contains("Enter your password. This field can't be empty"));
    }

    @Test
    public void loginWithPasswordOnly() {
        String email = "";
        String password = "Test@123@gmail";

        List<String> textErrors = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getErrors();

        Assert.assertTrue(textErrors.contains("Enter email"));
    }

    @Test
    public void loginWithEmptyForm() {
        String email = "";
        String password = "";

        List<String> textErrors = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getErrors();

        Assert.assertTrue(textErrors.contains("Enter email"));
        Assert.assertTrue(textErrors.contains("Enter your password. This field can't be empty"));
    }


}
