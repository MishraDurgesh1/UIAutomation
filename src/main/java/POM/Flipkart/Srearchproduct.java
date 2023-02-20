package POM.Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Srearchproduct extends LoginFlipkart{
        public static void searchClick()
        {
            WebElement Shirts = driver.findElement(By.xpath("//input[@type='text']"));
            Shirts.sendKeys("Shirts");
            Shirts.sendKeys(Keys.ENTER);
        }
    }

