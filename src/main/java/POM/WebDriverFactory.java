package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver driver;
    public static WebDriver getDriver(String browserName){ {
        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Mozila":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("You Entered invalid Browser!!!");
        }
        return driver;
    }
    }
}
