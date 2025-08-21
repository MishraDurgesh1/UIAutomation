package Page.AmazonTest;

import POM.page.AmazonPage;
import Page.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AmazonTest extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void loginBeforeEachTest() {
        FileInputStream fis;
        try {
            fis = new FileInputStream("src/main/java/resource/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void purchase() throws InterruptedException {
        AmazonPage amazonPage = new AmazonPage(driver);
        amazonPage.selectProduct();
        Thread.sleep(5000);
    }
    @Test(priority = 2,dependsOnMethods = "purchase")
    public void verifyHeader() {
        AmazonPage amazonPage = new AmazonPage(driver);
        System.out.println(amazonPage.verifyHeader());
        Assert.assertEquals(amazonPage.verifyHeader(), "Thank you for your order!");
    }
}
