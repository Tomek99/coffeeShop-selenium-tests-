package pl.coffeeShop.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;


import java.util.List;

public class LoginTest extends BaseTest{
    @Test
    public void loginWithValidDataTest() {
        String email = "test1@gmail.com";
        String password = "Test1@gmail";

         String textAlert = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleCorrectData();

        Assert.assertTrue(textAlert.contains("You have been logged in!"));
    }

    @Test
    public void loginWithInvalidEmailTest() {
        String email = "testg@gmail.com";
        String password = "Test1@gmail";

        String textError = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getError();

        Assert.assertEquals(textError, "Wrong password or email");
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        String email = "test1@gmail.com";
        String password = "Test@123@gmailWRONG";

        String textError = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getError();

        Assert.assertEquals(textError, "Wrong password or email");
    }

    @Test
    public void loginWithEmailOnlyTest() {
        String email = "test1@gmail.com";
        String password = "";


        List<String> textErrors = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getErrors();

        Assert.assertTrue(textErrors.contains("Enter your password. This field can't be empty"));
    }

    @Test
    public void loginWithPasswordOnlyTest() {
        String email = "";
        String password = "Test1@gmail";

        List<String> textErrors = new HomePage(driver)
                .openLoginPage()
                .fillLoginForm(email, password)
                .handleIncorrectData()
                .getErrors();

        Assert.assertTrue(textErrors.contains("Enter email"));
    }

    @Test
    public void loginWithEmptyFormTest() {
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
