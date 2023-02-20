package POM.Bank;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount extends AddCustomers {
    public static void openAccountClick() {
        driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
    }

    public static void enterCustomerName() {
        Select customernameSelect = new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
        customernameSelect.selectByVisibleText("Jyoti Verma");
    }
    public static void enterCurrency()
    {
        Select currencySelect = new Select(driver.findElement(By.xpath("//select[@id='currency']")));
        currencySelect.selectByVisibleText("Rupee");
    }
    public static void processClick()

    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.switchTo().alert().accept();
    }
}