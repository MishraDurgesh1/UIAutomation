package FlipkartPOM;

import Base.Utility;
import org.openqa.selenium.By;

public class OpenFlipkart extends Utility {
    public static void Flipkart() {
        openBrowser("https://www.flipkart.com/");
        driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
    }
}
