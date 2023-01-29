package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    static WebDriver driver;
    static File file;
    //Take Screenshot from web Pages:-
    public static void screenshot(String FileName) throws IOException {
        file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("image location" +FileName + ".jpeg"));

    }

    //Make Border for screenshot image:-
    public static void makeBorder(WebElement webElement){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border = '8px solid red' ",webElement);
    }

    public static void main(String[] args) throws IOException {
        driver=new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://www.google.co.in");
        WebElement webElement= driver.findElement(By.name("//*[@name='q']"));
        makeBorder(webElement);
        screenshot("GoogleSearch");

    }

}
