package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver driver;
    public static WebDriver getDriver(String browserName){ {
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
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
