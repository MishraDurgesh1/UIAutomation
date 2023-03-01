package POM.GoogleUI;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GmailPage extends Utility{
    public static void clickOnGmail(){
        driver.findElement(By.xpath("//a[@class='gb_n' and text()='Gmail']")).click();
    }

    public static WebElement screenShot(){
        return driver.findElement(By.xpath("//div[@class='rhhJr']"));
    }

}
