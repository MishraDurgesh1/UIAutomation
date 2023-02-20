package MyntraTests;

import POM.Myntra.PrintName;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class PrintNameTest extends PrintName {
    @Test(priority = '1')
    public static void PrintName() throws InterruptedException {
        openMyntra("https://www.myntra.com/");
        searchClick();
        waitBrowser(3000);
        popularityClickNew();
        waitBrowser(3000);
        sPrice();
        closeBrowser();
    }
}
