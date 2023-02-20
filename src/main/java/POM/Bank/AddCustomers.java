package POM.Bank;

import org.openqa.selenium.By;

public class AddCustomers extends LoginBank{
    public static void addCustomersClick()
    {
        driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();

    }
    public static void enterFirstName(String first_name)
    {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(first_name);}
    public static void enterLastName(String last_name) {
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(last_name);
    }
    public static void enterPostCode(String postcode)
    {
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(postcode);
    }
    public static void addCustomerClick()
    {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.switchTo().alert().accept();
    }
}
