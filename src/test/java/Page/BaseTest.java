package Page;

import POM.WebDriverFactory;
import Utils.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public class BaseTest {
    public static Properties prop = new Properties();
    protected WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
       driver = WebDriverFactory.getDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }
    @AfterMethod
    public void closeBrowser(){
        if(driver!=null){
            driver.close();
        }
    }
}
