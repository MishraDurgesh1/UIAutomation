package POM.page;

import Utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage extends Utility {
    public WebDriver driver;
    @FindBy(xpath = "//input[@id=\"user-name\"]")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id=\"login-button\"]")
    WebElement loginButton;
    @FindBy(xpath="//div[text()=\"Sauce Labs Backpack\"]")
    WebElement selectProduct;
    @FindBy(xpath="//button[@id=\"add-to-cart\"]")
    WebElement addToCart;
    @FindBy(xpath="//a[@class=\"shopping_cart_link\"]")
    WebElement cart_link;

    @FindBy(xpath="//button[@id=\"checkout\"]")
    WebElement checkout;
    @FindBy(xpath = "//input[@id=\"first-name\"]")
    WebElement firstName;
    @FindBy(xpath = "//input[@id=\"last-name\"]")
    WebElement lastName;
    @FindBy(xpath = "//input[@id=\"postal-code\"]")
    WebElement postalCode;
    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//button[@id=\"finish\"]")
    WebElement finishButton;
    @FindBy(xpath = "//h2[@class=\"complete-header\"]")
    WebElement completeHeader;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    public void selectProduct() throws InterruptedException {
        selectProduct.click();
        addToCart.click();
        cart_link.click();
        checkout.click();
        firstName.sendKeys("Selenium");
        lastName.sendKeys("Automation");
        postalCode.sendKeys("12345");
        continueButton.click();
        finishButton.click();
    }
    public String verifyHeader() {
        return completeHeader.getText();
    }
}
