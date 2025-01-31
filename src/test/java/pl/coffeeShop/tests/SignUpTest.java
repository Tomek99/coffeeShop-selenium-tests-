package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.models.SignUpUserModel;
import pl.coffeeShop.pages.HomePage;

import java.util.List;

public class SignUpTest extends BaseTest {
    @Test
    public void signUpWithValidDataTest() {
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
                .clickOnAcceptTermsCheckbox()
                .clickOnSignUpBtn()
                .getAlertMessage();

        Assert.assertEquals(textAlert, "You have been logged in!");
    }

    @Test
    public void signUpWithExistEmailTest() {

        SignUpUserModel user = new SignUpUserModel();
        user.setFirstName("Tomasz");
        user.setLastName("TEST");
        user.setEmail("szybko872@gmail.com");
        user.setPassword("Test123@");
        user.setConfirmPassword("Test123@");

        String error = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .clickOnAcceptTermsCheckbox()
                .handleSignUpBtnInvalidData()
                .getError("Email already exists");

        Assert.assertTrue(error.contains("Email already exists"));
    }

    @Test
    public void signUpWithInvalidFirstNameTest() {
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
                .clickOnAcceptTermsCheckbox()
                .handleSignUpBtnInvalidData()
                .getError("Must be 3 characters or more");

        Assert.assertTrue(error.contains("Must be 3 characters or more"));
    }

    @Test
    public void signUpWithInvalidLastNameTest() {
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
                .clickOnAcceptTermsCheckbox()
                .handleSignUpBtnInvalidData()
                .getError("Must be 3 characters or more");

        Assert.assertTrue(error.contains("Must be 3 characters or more"));

    }

    @Test
    public void signUpWithInvalidEmailTest() {
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
                .clickOnAcceptTermsCheckbox()
                .handleSignUpBtnInvalidData()
                .getError("Invalid email address");

        Assert.assertTrue(error.contains("Invalid email address"));
    }

    @Test
    public void signUpWithInvalidPasswordTest() {
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
                .clickOnAcceptTermsCheckbox()
                .handleSignUpBtnInvalidData()
                .getError("Passwords must match");

        Assert.assertTrue(error.contains("Passwords must match"));
    }

    @Test
    public void signUpWithInvalidConfirmPasswordTest() {
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
                .clickOnAcceptTermsCheckbox()
                .handleSignUpBtnInvalidData()
                .getError("Passwords must match");

        Assert.assertTrue(error.contains("Passwords must match"));
    }

    @Test
    public void signUpWithoutConsentsTest() {
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
    public void signUpWithEmptyDataTest() {
        SignUpUserModel user = new SignUpUserModel();

        List<String> errors = new HomePage(driver)
                .openSignUpPage()
                .fillFormWithValidData(user)
                .handleSignUpBtnInvalidData()
                .getErrors();

        Assert.assertEquals(errors.size(), 6);
    }
}
