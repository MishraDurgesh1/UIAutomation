package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;

@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefinitions"}, plugin = {"pretty", "html:target/cucumber-reports.html"}, monochrome = true)
@Listeners(listeners.TestListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
}
