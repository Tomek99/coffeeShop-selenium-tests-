package pl.coffeeShop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.coffeeShop.pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class ContactFormTest extends BaseTest {
    @Test
    public void fillFirstFormWithValidData()  {
      ArrayList<String> listOfString = new HomePage(driver)
              .openContactPage()
                .fillFirstForm("Tomasz Kowalski", "test@gmail.com", "Hello World!")
                .handleFirstForm()
                .handleAlert();

        Assert.assertEquals(listOfString.size(), 3);
    }

    @Test
    public void fillSecondFormWithValidData() {
        ArrayList<String> listOfString = new HomePage(driver)
                .openContactPage()
                .fillSecondForm("Tomasz Kowalski", "000 111 222", "Good Mornning")
                .handleSecondForm()
                .handleAlert();

        Assert.assertEquals(listOfString.size(), 3);
    }

    @Test
    public void fillFirstFormWithInvalidData() {
        List<String> errors = new HomePage(driver)
                .openContactPage()
                .fillFirstForm("a", "testgmail.com", "Gg")
                .handleFirstForm()
                .getErrors();

        Assert.assertTrue(errors.contains("Must be 4 characters or more"));
        Assert.assertTrue(errors.contains("Invalid email address"));
        Assert.assertTrue(errors.contains("Must be 5 characters or more"));
    }

    @Test
    public void fillSecondFormWithInvalidData() {
        List<String> errors = new HomePage(driver)
                .openContactPage()
                .fillSecondForm("gg", "000 ", "Gg")
                .handleSecondForm()
                .getErrors();

        Assert.assertTrue(errors.contains("Must be 4 characters or more"));
        Assert.assertTrue(errors.contains("Phone number is not valid"));
        Assert.assertTrue(errors.contains("Must be 5 characters or more"));
    }

    @Test
    public void sendEmptyFirstForm() {
        List<String> errors = new HomePage(driver)
                .openContactPage()
                .fillFirstForm("", "", "")
                .handleFirstForm()
                .getErrors();

        Assert.assertEquals(errors.size(), 3);
    }
    @Test
    public void sendEmptySecondForm() {
        List<String> errors = new HomePage(driver)
                .openContactPage()
                .fillSecondForm("", "", "")
                .handleSecondForm()
                .getErrors();

        Assert.assertEquals(errors.size(), 3);
    }
}
