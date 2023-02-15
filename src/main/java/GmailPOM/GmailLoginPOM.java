package GmailPOM;

import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

public class GmailLoginPOM extends OpenGooglePOM {
    public static void GmailLoginPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@data-pid=\"23\"]")).click();
        driver.findElement(By.xpath( "/html/body/header/div/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("er.harshit2000@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("harshit@2000");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class=\"agP aFw\"]")).sendKeys("er.harshit2000@gmail.com");
        driver.findElement(By.xpath("//div[@aria-label=\"Message Body\"]")).sendKeys("hi i am harshit");
        driver.findElement(By.xpath("//div[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"]")).click();
    }
}
