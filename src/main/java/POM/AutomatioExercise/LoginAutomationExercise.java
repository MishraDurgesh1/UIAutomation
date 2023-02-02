package POM.AutomatioExercise;

import Base.Utility;
import org.openqa.selenium.By;

public class LoginAutomationExercise extends Utility {


    public static void openautomationexercise()
    {
        openBrowser("https://automationexercise.com/");
    }
    public static void login()
    {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
    }
    public static void enterName(String name)
    {
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys();
    }
    public static void enterEmail(String email)
    {
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys();
    }
    public static void enterPassword(String password)
    {
        driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys();
    }
    public static void enterDays(int days)
    {
        driver.findElement(By.xpath("//[@id='days']/option[9]")).click();
    }
    public static void enterMonths(int months)
    {
        driver.findElement(By.xpath("//[@id='months']/option[8]")).click();
    }
    public static void enterYears(int years)
    {
        driver.findElement(By.xpath("//[@id='years']/option[23]")).click();
    }
    public static void newsletter()
    {
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
    }
    public static void optin()
    {
        driver.findElement(By.xpath("//input[@id='optin']")).click();
    }
    public static void enterFirstname(String first_name)
    {
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).click();
    }
    public static void enterLastname(String last_name)
    {
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).click();
    }
    public static void enterCompanyname(String companyname)
    {
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys();
    }
    public static void address1(String address1)
    {
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys();
    }
    public static void address2(String address2)
    {
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys();
    }
    public static void state(String state)
    {
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys();
    }
    public static void city(String city)
    {
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys();
    }
    public static void zipcode(int zipcode)
    {
        driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys();
    }
    public static void mobile_number(int mobile_number) {
        driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys();
    }
}
