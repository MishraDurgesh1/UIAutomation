package stepdefinitions;

import POM.page.AmazonPage;
import Page.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps extends BaseTest {
    @Given("User clicks on Mobile tab")
    public void user_clicks_on_mobile_tab() {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.clickMobileTab();
    }

    @When("User clicks on brand filter and select {string}")
    public void user_clicks_on_brand_filter_and_select(String brand) {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.clickOnBrandFilter(brand);
    }

    @Then("User should be able to see the mobiles of selected {string}")
    public void user_should_be_able_to_see_the_mobiles_of_selected_brand(String brand) {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.verifyMobilesOfSelectedBrand(brand);
    }

    @Then("User clicks on first mobile and add to cart")
    public void user_clicks_on_mobile_and_add_to_cart() {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.clickOnAddToCart();
    }

    @Then("User clicks on cart icon and proceed to checkout")
    public void user_clicks_on_cart_icon_and_proceed_to_checkout() {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.clickOnCartIcon();
    }
}
