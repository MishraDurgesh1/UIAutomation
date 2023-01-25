package POM.Module1;

import Base.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Haaristest {

public static void main(String[]args) {
  WebDriver driver=new ChromeDriver();
  WebDriverManager.chromedriver().setup();
  driver.get("https://automationexercise.com/");
  driver.manage().window().maximize();
  driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click();
    }
}
