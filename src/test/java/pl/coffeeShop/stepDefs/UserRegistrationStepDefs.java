package pl.coffeeShop.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pl.coffeeShop.models.SignUpUserModel;
import pl.coffeeShop.pages.HomePage;
import pl.coffeeShop.pages.SignUpPage;
import pl.coffeeShop.utils.DriverFactory;

import java.util.List;

public class UserRegistrationStepDefs {

    HomePage homePage;
    SignUpPage signUpPage = new SignUpPage(DriverFactory.getDriver());
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Given("The user is located on home page")
    public void the_user_is_located_on_home_page() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.openHomePage();
    }
    @When("Hover over userBtn and click on sign up register")
    public void hover_over_user_btn_and_click_on_sign_up_register() {
        homePage.openSignUpPage();
    }

    @Then("User is redirect to home page")
    public void user_is_redirect_to_home_page() {
        String alertText = homePage.getAlertMessage();

        Assert.assertTrue(alertText.contains("You have been logged in!"));
    }
    @Then("The register form is invisible to the user")
    public void the_register_form_is_invisible_to_the_user() {
        Assert.assertEquals(signUpPage.getUsernameInputSize(), 0);
    }

    @And("Accept formal consents")
    public void acceptFormalConsents() {
        signUpPage.clickOnAcceptTermsCheckbox();

    }

    @And("Click on sign up button")
    public void clickOnSignUpButton() {
        signUpPage.clickOnSignUpBtn();
    }

    @And("Fill out the register form with valid data")
    public void fillOutTheRegisterFormWithValidData() {
        Faker faker = new Faker();
        SignUpUserModel  user = new SignUpUserModel();

        String password = faker.internet().password() + "U@";

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage.fillFormWithValidData(user);
    }

    @And("Fill out the register form with invalid password {string}")
    public void fillOutTheRegisterFormWithInvalidPassword(String password) {
        Faker faker = new Faker();
        SignUpUserModel  user = new SignUpUserModel();

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage.fillFormWithValidData(user);

    }

    @Then("The notification about incorrect password is displayed {string}")
    public void theNotificationAboutIncorrectPasswordIsDisplayed(String textError ) {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains(textError));
    }

    @Then("The notification about incorrect data is displayed")
    public void theNotificationAboutIncorrectDataIsDisplayed() {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertEquals(errorText.size(), 6);
    }

    @And("Fill out the register form with invalid confirm password")
    public void fillOutTheRegisterFormWithInvalidConfirmPassword() {
        Faker faker = new Faker();
        signUpPage = new SignUpPage(DriverFactory.getDriver());
        SignUpUserModel  user = new SignUpUserModel();

        String password = "Test123@5";
        String confirmPasswordIncorrect = "Test123@55";

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(password);
        user.setConfirmPassword(confirmPasswordIncorrect);

        signUpPage.fillFormWithValidData(user);
    }

    @Then("The notification about incorrect confirm password is displayed")
    public void theNotificationAboutIncorrectConfirmPasswordIsDisplayed() {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains("Passwords must match"));
    }

    @And("Fill out the register form with invalid email {string}")
    public void fillOutTheRegisterFormWithInvalidEmail(String email) {
        Faker faker = new Faker();
        SignUpUserModel  user = new SignUpUserModel();

        String password = faker.internet().password() + "U@";

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(email);
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage.fillFormWithValidData(user);
    }

    @Then("The notification about incorrect email is displayed {string}")
    public void theNotificationAboutIncorrectEmailIsDisplayed(String error) {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains(error));
    }

    @And("Fill out the register form with exist email")
    public void fillOutTheRegisterFormWithExistEmail() {
        Faker faker = new Faker();
        SignUpUserModel  user = new SignUpUserModel();

        String password = faker.internet().password() + "U@";

        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail("szybko872@gmail.com");
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage.fillFormWithValidData(user);
    }

    @Then("The notification about exist email is displayed")
    public void theNotificationAboutExistEmailIsDisplayed() {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains("Email already exists"));
    }

    @And("Fill out the register form with invalid name {string}")
    public void fillOutTheRegisterFormWithInvalidName(String name) {
        Faker faker = new Faker();
        SignUpUserModel  user = new SignUpUserModel();

        String password = faker.internet().password() + "U@";

        user.setFirstName(name);
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage.fillFormWithValidData(user);
    }

    @Then("The notification about incorrect name is displayed {string}")
    public void theNotificationAboutIncorrectNameIsDisplayed(String error) {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains(error));

    }

    @And("Fill out the register form with invalid last name {string}")
    public void fillOutTheRegisterFormWithInvalidLastName(String name) {
        Faker faker = new Faker();
        SignUpUserModel  user = new SignUpUserModel();

        String password = faker.internet().password() + "U@";

        user.setFirstName(faker.name().firstName());
        user.setLastName(name);
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage.fillFormWithValidData(user);
    }

    @Then("The notification about incorrect last name is displayed {string}")
    public void theNotificationAboutIncorrectLastNameIsDisplayed(String error) {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains(error));
    }


    @Then("The notification about accept terms & Conditions is displayed")
    public void theNotificationAboutAcceptTermsConditionsIsDisplayed() {
        List<String> errorText = signUpPage.getErrors();
        Assert.assertTrue(errorText.contains("Accept Terms & Conditions is required"));
    }


}
