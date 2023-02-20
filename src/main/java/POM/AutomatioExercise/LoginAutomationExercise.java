package POM.AutomatioExercise;
import Base.Utility;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

public class LoginAutomationExercise extends Utility {
    public static void openautomationexercise(String url) {

        openBrowser(url);
    }

    public static void signUpHomepageClick()
    {
        driver.findElement(xpath("//a[@href='/login']")).click();
    }

    public static void enterName(String name) {
      driver.findElement(xpath("//input[@data-qa='signup-name']")).sendKeys(name);
    }

    public static void enterEmail(String email) {
        driver.findElement(xpath("//input[@data-qa='signup-email']")).sendKeys(email);
    }
    public static void signUpClick()

    {
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }
}
