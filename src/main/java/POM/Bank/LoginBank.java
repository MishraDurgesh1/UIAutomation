package POM.Bank;
import Base.Utility;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class LoginBank  extends Utility {
    public static void openbank(String url) {
        openBrowser(url);
    }
    public static void bankManagerClick()
    {
        driver.findElement(xpath("//button[contains(text(),'Bank Manager')]")).click();
    }
}