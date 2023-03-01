package GoogleTest;

import POM.GoogleUI.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class SearchPageTest extends SearchPage {
    @Test(priority = 1)
    public static void searchTest() throws InterruptedException {
        openBrowser("https://www.google.co.in","Edge");
        searchWordWithGoogle("JAVA");
        waitBrowser(2000);
        Assert.assertEquals("JAVA - Google Search", getTitle());
        closeBrowser();
    }

    @Test(priority = 2)
    public static void countSearchWordTest() {
        openBrowser("https://www.google.co.in","Edge");
        searchWordWithGoogle("Java");
        countWordOnPage();
        closeBrowser();
    }

    @Test(priority = 3)
    public static void takeScreenshotOfSearchBar() throws IOException {
        openBrowser("https://www.google.co.in","Edge");
        makeBorder(screenshotElement());
        screenshot("GoogleSearchBar");
        closeBrowser();
    }
}







