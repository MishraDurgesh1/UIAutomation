package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@Smoke",
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)
@Listeners(listeners.TestListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
}
