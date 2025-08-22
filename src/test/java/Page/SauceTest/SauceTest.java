package Page.SauceTest;

import POM.page.SauceDemoPage;
import Page.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class SauceTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void loginBeforeEachTest() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/java/resource/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SauceDemoPage sauceDemoPage = new SauceDemoPage(driver);
        sauceDemoPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void purchase() throws InterruptedException {
        SauceDemoPage sauceDemoPage = new SauceDemoPage(driver);
        sauceDemoPage.selectProduct();
        Thread.sleep(5000);
    }
    @Test(priority = 2,dependsOnMethods = "purchase")
    public void verifyHeader() {
        SauceDemoPage sauceDemoPage = new SauceDemoPage(driver);
        System.out.println(sauceDemoPage.verifyHeader());
        Assert.assertEquals(sauceDemoPage.verifyHeader(), "Thank you for your order!");
    }
}
