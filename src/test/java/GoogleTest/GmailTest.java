package GoogleTest;

import POM.GoogleUI.GmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GmailTest extends GmailPage {
    @Test(priority = 1)
    public static void clickGmailTest(){
        openBrowser("https://www.google.co.in","Edge");
        clickOnGmail();
        Assert.assertEquals("Gmail: Private and secure email at no cost | Google Workspace",getTitle());
        closeBrowser();
    }

    @Test(priority = 2)
    public static void takeScreenshotOfGmailPageTest() throws IOException {
        openBrowser("https://www.google.co.in","Edge");
        clickOnGmail();
        makeBorder(screenShot());
        screenshot("GmailBoard");
    }
}
