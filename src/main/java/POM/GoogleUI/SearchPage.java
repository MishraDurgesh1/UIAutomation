package POM.GoogleUI;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage extends Utility {

    public static void searchWordWithGoogle(String word) {
        WebElement searchElement = driver.findElement(By.xpath("//input[@name='q']"));
        searchElement.sendKeys(word);
        searchElement.sendKeys(Keys.ENTER);
    }

    public static void countWordOnPage() {
        List<WebElement> em = driver.findElements(By.tagName("em"));
        int size = em.size();
        System.out.println("Total number of searched words are = " + size);
    }
    public static WebElement screenshotElement(){
        return driver.findElement(By.xpath("//input[@name='q']"));
    }
}





