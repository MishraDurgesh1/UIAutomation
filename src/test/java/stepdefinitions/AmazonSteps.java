package stepdefinitions;

import POM.page.AmazonPage;
import Page.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps extends BaseTest {
    AmazonPage amazonPage;

    public AmazonSteps() {
        amazonPage = new AmazonPage(driver);
    }

    @Given("User clicks on Mobile tab")
    public void user_clicks_on_mobile_tab() {
        amazonPage.clickMobileTab();
    }

    @When("User clicks on brand filter and select {string}")
    public void user_clicks_on_brand_filter_and_select(String brand) {
        amazonPage.clickOnBrandFilter(brand);
    }

    @Then("User should be able to see the mobiles of selected {string}")
    public void user_should_be_able_to_see_the_mobiles_of_selected_brand(String brand) {
        amazonPage.verifyMobilesOfSelectedBrand(brand);
    }

    @Then("User clicks on first mobile and add to cart")
    public void user_clicks_on_mobile_and_add_to_cart() {
        amazonPage.clickOnAddToCart();
    }

    @Then("User clicks on cart icon and proceed to checkout")
    public void user_clicks_on_cart_icon_and_proceed_to_checkout() {
        amazonPage.clickOnCartIcon();
    }
}
