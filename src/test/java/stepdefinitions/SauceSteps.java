package stepdefinitions;

import POM.page.AmazonPage;
import Page.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
@Slf4j
public class SauceSteps extends BaseTest {
    AmazonPage amazonPage;

    @Given("Open the browser and navigate to the application")
    public void open_the_browser_and_navigate_to_the_application() {
        log.info("Open the browser and navigate to the application");
        amazonPage = new AmazonPage(driver);
    }

    @When("Enter the {string} and {string} and click on login")
    public void enter_the_username_and_password(String username, String password) {
        log.info("||--User enters their credential--||");
        amazonPage=new AmazonPage(driver);
        amazonPage.login(username, password);
        log.info("||--User logged in successfully--||");
    }

    @Then("Verify the title of the page")
    public void verify_the_title_of_the_page() {
        log.info("||--Confirm Title--||");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Swag Labs");
    }
}
