package AutomationTest;

import POM.AutomatioExercise.EnterAccountInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;


public class AutomationAccountInformationTest extends EnterAccountInformation {

    @Test(priority = 1)
    public static void EnterInformationTest() {
        openautomationexercise("https://automationexercise.com");
        Assert.assertEquals("Automation Exercise",driver
                .getTitle());
        signUpHomepageClick();
        Assert.assertEquals("New User Signup!",driver.findElement(xpath("//div[@class='signup-form']/h2")).getText());
        enterName("Jyoti Verma");
        enterEmail(("jyoti36@yopmail.com"));
        signUpClick();
        Assert.assertEquals("ENTER ACCOUNT INFORMATION",driver.findElement(xpath("//h2[@class='title text-center']/b")).getText());
        titleClicks();
        enterPassword("Jyoti0108");
        enterDays();
        enterMonths();
        enterYears();
        newsLetterClick();
        optinClick();
    }
}