package POM.page;

import Utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBMPage extends Utility {
    public WebDriver driver;
    @FindBy(xpath="(//p[@class=\"atom text--paragraph  type--normal  font--align-Mcenter          \" ])[4]")
    WebElement borrowButton;

    @FindBy(xpath = "//a[contains(text(),'Credit cards')]")
    WebElement creditCardsIcon;

    @FindBy(xpath = "//div//h4[text()='Premier'] | //span[@text='Apply now']")
    WebElement applyNowPremier;

    public FBMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBorrowButton(){
        clickWhenReady(driver,borrowButton);
    }
    public void clickOnCreditCardsIcon(){
        creditCardsIcon.click();
    }
    public void clickOnApplyNowPremier(){
        applyNowPremier.click();
    }
}
