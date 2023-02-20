package AutomationTest;

import POM.AutomatioExercise.LoginAutomationExercise;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class AutomationLoginTest extends LoginAutomationExercise {
    @Test(priority = '1')
    public static void LoginAutomation() {
        openautomationexercise("https://automationexercise.com");
        Assert.assertEquals("Automation Exercise",driver
                .getTitle());
        signUpHomepageClick();
        Assert.assertEquals("New User Signup!",driver.findElement(xpath("//div[@class='signup-form']/h2")).getText());
        enterName("Jyoti Verma");
        enterEmail(("jyoti36@yopmail.com"));
        signUpClick();
    }
}


