package POM.Myntra;
import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMyntra extends Utility {
    public static void openMyntra(String url)
    {
        openBrowser(url);

    }
    public static void searchClick()
    {
       WebElement Shirts = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
       Shirts.sendKeys("Shirts");
       Shirts.sendKeys(Keys.ENTER);
    }
    public static void popularityClickNew()
    {
        WebElement element = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        driver.findElement(By.xpath("//ul[@class=\"sort-list\"]/li[3]")).click();
    }
}
