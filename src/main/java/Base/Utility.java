package Base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Utility {
    public static WebDriver driver;
    public static void openBrowser(String url){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static String getTitle(){
       return driver.getTitle();
    }

    public static String getUrl(){
        return driver.getCurrentUrl();
    }

    public static void windowScroll(){
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    public static String javaToJsonConvert(ArrayList arrayList) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        ArrayList<String> arrayList1=new ArrayList<>(arrayList);
        return mapper.writeValueAsString(arrayList1);
    }

    public static ArrayList jsonToJavaConvert(String jsString) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
       return mapper.readValue(jsString,ArrayList.class);
    }

    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public static void alertSend(String str){
        driver.switchTo().alert().sendKeys(str);
    }

    public static void alertGetText(){
        driver.switchTo().alert().getText();
    }

    public static void waitBrowser(int timeWait) throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
