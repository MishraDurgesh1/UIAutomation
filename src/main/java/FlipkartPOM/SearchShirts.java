package FlipkartPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchShirts extends OpenFlipkart {
    public static void Shirts(){
        driver.findElement(By.xpath("//input[@class=\"_3704LK\"]")).sendKeys("Mens casual shirt");
        driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
        List<WebElement> allproduct =driver.findElements(By.xpath("//div[@class=\"_30jeq3\"]"));
        for (WebElement Shirt : allproduct) {
            String Ha = Shirt.getText();
            String Rs=Ha.substring(1,4);
            int Hi=Integer.parseInt((Rs));
            if(Hi<=400)
            {
                Shirt.click();
            }
        }

    }
}
