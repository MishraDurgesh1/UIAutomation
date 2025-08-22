package stepdefinitions;

import POM.page.FBMPage;
import Page.BaseTest;
import io.cucumber.java.en.*;

public class FBMSteps extends BaseTest {
    @Given("User clicks on Borrow Button")
    public void user_clicks_on_borrow_button() {
        FBMPage fBMPage = new FBMPage(driver);
        fBMPage.clickOnCookies();
        fBMPage.clickOnBorrowButton();
    }
    @When("User clicks on Credit Cards Icon")
    public void user_clicks_on_credit_cards_icon() {
       FBMPage page=new FBMPage(driver);
       page.clickOnCreditCardsIcon();
    }

    @When("User clicks on Apply Now Premier Credit card")
    public void user_clicks_on_apply_now_premier_credit_card() {
        FBMPage page=new FBMPage(driver);
        page.clickOnApplyNowPremier();
    }

    @Then("User should be able to see the Apply Now Premier page")
    public void user_should_be_able_to_see_the_apply_now_premier_page() {

    }
}
