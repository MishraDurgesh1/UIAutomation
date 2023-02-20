package POM.AutomatioExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class EnterAccountInformation extends LoginAutomationExercise {
    public static void titleClicks()


    {
        driver.findElement(By.xpath("//input[@value='Mrs']")).click();
    }

    public static void enterPassword(String password) {
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys(password);
    }

    public static void enterDays() {
        Select dateSelect = new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
        dateSelect.selectByIndex(8);

    }

    public static void enterMonths() {
        Select monthSelect = new Select(driver.findElement(By.xpath("//select[@data-qa='months']")));
        monthSelect.selectByIndex(7);

    }

    public static void enterYears() {
        Select yearSelect = new Select(driver.findElement(By.xpath("//select[@data-qa='years']")));
        yearSelect.selectByIndex(10);
    }

    public static void newsLetterClick() {
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
    }

    public static void optinClick() {
        driver.findElement(By.xpath("//input[@id='optin']")).click();
    }

}
