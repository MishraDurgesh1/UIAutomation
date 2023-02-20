package POM.AutomatioExercise;
import org.openqa.selenium.By;

public class Addressinformation extends EnterAccountInformation{
    public static void enterFirstname(String first_name) {
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys(first_name);
    }

    public static void enterLastname(String last_name) {
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys(last_name);
    }

    public static void enterCompanyname(String companyname) {
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys(companyname);
    }

    public static void enterAddress(String address) {
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
    }

    public static void enterAddress2(String address2) {
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys(address2);
    }

    public static void enterState(String state)
    {
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
    }

    public static void enterCity(String city)
    {
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
    }

    public static void enterZipcode(String zipcode) {
        driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys(zipcode);
    }

    public static void enterMobile_Number(String mobile_number) {
        driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys(mobile_number);
    }
    public static void createAccountClick()

    {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
    }
    public static void continueClick()
    {
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
    }
}
