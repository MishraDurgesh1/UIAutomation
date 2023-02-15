package XYZBankPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer extends OpenXYZBank {
    public static void AddCustomer() {
        driver.findElement(By.xpath("//button[@ng-class=\"btnClass1\"]")).click();
        driver.findElement(By.xpath("//input[@ng-model=\"fName\"]")).sendKeys("Harshit");
        driver.findElement(By.xpath("//input[@ng-model=\"lName\"]")).sendKeys("Sharma");
        driver.findElement(By.xpath("//input[@ng-model=\"postCd\"]")).sendKeys("208002");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        alertAccept();
    }
    public static void Customers(){
        driver.findElement(By.xpath("//button[@ng-class=\"btnClass3\"]")).click();
    }
    public static void OpenAccount() {
        driver.findElement(By.xpath("//button[@ng-class=\"btnClass2\"]")).click();
        Select select=new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
        select.selectByVisibleText("Harshit Sharma");
        Select currency=new Select(driver.findElement(By.xpath("//select[@id=\"currency\"]")));
        currency.selectByVisibleText("Rupee");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        alertAccept();
    }
}
