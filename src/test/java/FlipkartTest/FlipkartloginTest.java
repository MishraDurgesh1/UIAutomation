package FlipkartTest;

import POM.Flipkart.LoginFlipkart;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FlipkartloginTest extends LoginFlipkart {
    @Test(priority = '1')
    public static void LoginFlipkart() {
        openflipkart("https://www.flipkart.com/");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
    }
}
