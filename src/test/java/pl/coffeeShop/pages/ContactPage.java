package pl.coffeeShop.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.profiler.model.TypeObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.coffeeShop.utils.SeleniumHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactPage {
    @FindBy(name = "name_form_one")
    private WebElement name_input_one;
    @FindBy(name = "email")
    private WebElement email_input_one;
    @FindBy(name = "name_form_two")
    private WebElement name_input_two;
    @FindBy(name = "number")
    private WebElement phone_input_two;
    @FindBy(id = "contactFormComment0")
    private WebElement textarea_comment_one;
    @FindBy(id = "contactFormComment1")
    private WebElement textarea_comment_two;
    @FindBy(id = "btnFormContact0")
    private WebElement btn_form_contact0;
    @FindBy(id = "btnFormContact1")
    private WebElement btn_form_contact1;

    @FindBy(className = "ErrMessage_errorComponent__HOwSm")
    List<WebElement> errors;


    WebDriver driver;

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public ContactPage fillFirstForm(String name, String email, String comment) {
        name_input_one.sendKeys(name);
        email_input_one.sendKeys(email);
        textarea_comment_one.sendKeys(comment);
        return this;

    }

    public ContactPage fillSecondForm(String name, String phone, String comment) {
        name_input_two.sendKeys(name);
        phone_input_two.sendKeys(phone);
        textarea_comment_two.sendKeys(comment);
        return this;
    }

    public ContactPage handleFirstForm() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('btnFormContact0').click();");
        return this;
    }

    public ContactPage handleSecondForm() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.getElementById('btnFormContact1').click();");
        return this;
    }

    public List<String> getErrors() {
        return errors.stream().map(WebElement::getText).toList();
    }

    public  ArrayList<String> handleAlert()  {
        SeleniumHelper.waitForAlert(driver);
        String text = driver.switchTo().alert().getText();;

        String[] elements = text.split(",");
        List<String> fixedLenghtList = Arrays.asList(elements);
        return new ArrayList<>(fixedLenghtList);
    }
}
