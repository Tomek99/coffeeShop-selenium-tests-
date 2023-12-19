package pl.coffeeShop.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pl.coffeeShop.models.SignUpUserModel;
import pl.coffeeShop.pages.HomePage;
import pl.coffeeShop.pages.SignUpPage;
import pl.coffeeShop.utils.DriverFactory;

public class UserRegistrationStepDefs {

    HomePage homePage;
    SignUpPage signUpPage;
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
    @When("Fill out the register form with valid data and accept formal consents.")
    public void fill_out_the_register_form_with_valid_data_and_accept_formal_consents() {
        Faker faker = new Faker();
        signUpPage = new SignUpPage(DriverFactory.getDriver());
        String password = faker.internet().password() + "U@";

        SignUpUserModel  user = new SignUpUserModel();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(password);
        user.setConfirmPassword(password);

        signUpPage
                .fillFormWithValidData(user)
                .clickOnAcceptTermsCheckbox()
                .clickOnSignUpBtn();

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
}
