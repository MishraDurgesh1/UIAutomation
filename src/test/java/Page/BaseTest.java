package Page;

import POM.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.util.Properties;

import static Utils.Utility.simpleWait;

public class BaseTest {
    public static Properties prop = new Properties();
    public static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openBrowser() {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/resource/config.properties");
            prop.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties file");
        }

        driver = WebDriverFactory.getDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        if (driver != null) {
            simpleWait(4);
            driver.quit();
        }
    }
}
