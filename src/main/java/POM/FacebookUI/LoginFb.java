package POM.FacebookUI;

import Base.DownloadElements;
import Base.ExcelOperation;
import Base.Utility;
import org.openqa.selenium.By;

public class LoginFb extends Utility{


    public static void openFacebook(){
        openBrowser("https://www.facebook.com/","Chrome");
    }
    public static void enterEmail(String email){
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public static void enterPassword(String pwd){
        driver.findElement(By.id("pass")).sendKeys(pwd);
    }

    public static void clickOnLogin(){
        driver.findElement(By.xpath("//*[@name='login']")).click();
    }
}
