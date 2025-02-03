package pl.coffeeShop.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pl.coffeeShop.pages.AdminLoginPage;
import pl.coffeeShop.pages.AdminPanelPage;
import pl.coffeeShop.pages.HomePage;
import pl.coffeeShop.pages.SignUpPage;
import pl.coffeeShop.utils.DriverFactory;

import java.time.Duration;
import java.util.List;

public class AdminLoginStepDefs {
    HomePage homePage;
    AdminLoginPage adminLoginPage;


//    @After
//    public void tearDown() {
//
//        DriverFactory.quitDriver();
//    }


    @Given("Admin is located in admin login form")
    public void admin_is_located_in_admin_login_form() {
        adminLoginPage = new AdminLoginPage(DriverFactory.getDriver());
        adminLoginPage.openAdminLoginPage();
    }

//   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
    @When("Fill login input")
    public void fill_login_input() {
        String login = "admin1";
        adminLoginPage.fillAdminLoginInput(login);
    }


    @And("Fill password input")
    public void fill_password_input() {
        String password = "Nimda1";
        adminLoginPage.fillAdminPasswordInput(password);
    }
    @When("Fill login input {string}")
    public void fill_login_input(String login) {
        adminLoginPage.fillAdminLoginInput(login);
    }
    @When("Fill password input {string}")
    public void fill_password_input(String password) {
        adminLoginPage.fillAdminPasswordInput(password);
    }
    @When("Click on login button")
    public void click_on_login_button() {
        adminLoginPage.clickOnAdminLoginValidBtn();
    }

    @When("Click on login button invalid data")
    public void clickOnLoginButtonInvalidData() {
        adminLoginPage.clickOnAdminLoginInvalidBtn();
    }


    @Then("Admin is redirected to admin panel")
    public void admin_is_redirected_to_admin_panel() {
        String titleExpected = "Welcome to the admin panel build-in user!";
        String title = new AdminPanelPage(DriverFactory.getDriver()).welcomeAdminPanelText();
        Assert.assertEquals(title, titleExpected);

    }

    @Then("The notification about invalid data is displayed")
    public void theNotificationAboutInvalidDataIsDisplayed() {
        String expectedError = "Invalid data, try again...";
        String error = adminLoginPage.getError();

        Assert.assertEquals(error, expectedError);

    }

    @When("Click on return home btn")
    public void clickOnReturnHomeBtn() {
        adminLoginPage.clickOnReturnHomeBtn();
    }


    @Then("Redirect to home page")
    public void redirectToHomePage() {
        String expectedTitle = "fresh coffee in the morning";
        String title = new HomePage(DriverFactory.getDriver()).getTitleFreshCoffeeInTheMorning();

        Assert.assertEquals(title,expectedTitle);
    }


    @Then("The notification about invalid login and password is displayed")
    public void theNotificationAboutInvalidLoginAndPasswordIsDisplayed() {
        int expectedErrors = 2;
        List<String> errors = adminLoginPage.getErrors();

        Assert.assertEquals(errors.size(), expectedErrors);

    }
}
