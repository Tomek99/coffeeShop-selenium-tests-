package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.models.SignUpUserModel;
import pl.coffeeShop.pages.HomePage;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class SignUpTest extends BaseTest {
    @Test
    public void signUpWithValidData() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Tomasz");
        user.setLastName("TEST");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String textAlert = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtn()
                .getLogInAlert();

        Assert.assertEquals(textAlert, "You have been logged in!");
    }

    @Test
    public void signUpWithExistEmail() {

        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Tomasz");
        user.setLastName("TEST");
        user.setEmail("szybko872@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtnInvalidData()
                .getError("Email already exists");

        Assert.assertTrue(error.contains("Email already exists"));
    }

    @Test
    public void signUpWithInvalidFirstName() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Te");
        user.setLastName("Test");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtnInvalidData()
                .getError("Must be 3 characters or less");

        Assert.assertTrue(error.contains("Must be 3 characters or less"));
    }

    @Test
    public void signUpWithInvalidLastName() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Test");
        user.setLastName("Te");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtnInvalidData()
                .getError("Must be 3 characters or less");

        Assert.assertTrue(error.contains("Must be 3 characters or less"));

    }

    @Test
    public void signUpWithInvalidEmail() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("test" + number + "gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtnInvalidData()
                .getError("Invalid email address");

        Assert.assertTrue(error.contains("Invalid email address"));
    }

    @Test
    public void signUpWithInvalidPassword() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Tes");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtnInvalidData()
                .getError("Passwords must match");

        Assert.assertTrue(error.contains("Passwords must match"));
    }

    @Test
    public void signUpWithInvalidConfirmPassword() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Test");
        user.setLastName("Test");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleCheckBox()
                .handleSignUpBtnInvalidData()
                .getError("Passwords must match");

        Assert.assertTrue(error.contains("Passwords must match"));
    }

    @Test
    public void signUpWithoutConsents() {
        int number = (int) (Math.random() * 1000);
        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Tomasz");
        user.setLastName("TEST");
        user.setEmail("test" + number + "@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleSignUpBtnInvalidData()
                .getError("Accept Terms & Conditions is required");

        Assert.assertTrue(error.contains("Accept Terms & Conditions is required"));
    }

    @Test
    public void signUpWithEmptyData() {
        SignUpUserModel user = new SignUpUserModel();

        List<String> errors = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleSignUpBtnInvalidData()
                .getErrors();

        Assert.assertEquals(errors.size(), 6);
    }
}
