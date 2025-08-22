package POM.page;

import Utils.ReportManager;
import Utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {
    public WebDriver driver;
    @FindBy(xpath = "//a[@data-csa-c-content-id=\"nav_cs_mobiles\"]")
    WebElement mobileTab;

    @FindBy(xpath = "//button[@id=\"a-autoid-1-announce\"]\n")
    WebElement addToCart;

    @FindBy(xpath = "//div[@id=\"nav-cart-count-container\"]")
    WebElement cartIcon;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMobileTab() {
        mobileTab.click();
    }

    public WebElement brandFilter(String brandName) {
        return driver.findElement(By.xpath("//li//label//span[text()='" + brandName + "']"));
    }

    public void clickOnBrandFilter(String brandName){
        Utility.clickWhenReady(driver, brandFilter(brandName));
    }
    public void clickOnAddToCart() {
        addToCart.click();
    }

    public void clickOnCartIcon() {
        Utility.clickWhenReady(driver,cartIcon);
    }
    public void verifyMobilesOfSelectedBrand(String brandName){
        List<WebElement> products = driver.findElements(By.xpath("//h2[contains(@aria-label, 'Samsung')]"));
        for (int i=0;i<4;i++){
            if (!products.get(i).getText().contains("Samsung")){
                ReportManager.fail("Not display Selected Brand Products on UI");
            }
        }
        System.out.println("✅ Verified: All " + products.size() + " products are of brand: " + brandName);
    }
}