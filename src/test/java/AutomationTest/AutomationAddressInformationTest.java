package AutomationTest;
import POM.AutomatioExercise.Addressinformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class AutomationAddressInformationTest extends Addressinformation
{
    @Test(priority = '1')
    public static void Addressinformation() {
        openautomationexercise("https://automationexercise.com");
        Assert.assertEquals("Automation Exercise", driver
                .getTitle());
        signUpHomepageClick();
        Assert.assertEquals("New User Signup!", driver.findElement(xpath("//div[@class='signup-form']/h2")).getText());
        enterName("Jyoti Verma");
        enterEmail(("jyoti49@yopmail.com"));
        signUpClick();
        titleClicks();
        enterPassword("Jyoti0108");
        enterDays();
        enterMonths();
        enterYears();
        newsLetterClick();
        optinClick();
        enterFirstname("Jyoti");
        enterLastname("Verma");
        enterCompanyname("Thoughts Big");
        enterAddress("Mall road");
        enterAddress2("BSNL office");
        enterState("UP");
        enterCity("Kanpur");
        enterZipcode("208001");
        enterMobile_Number("1234567889");
        createAccountClick();
        Assert.assertEquals("ACCOUNT CREATED!",driver.findElement(xpath("//*[@id='form']/div/div/div/h2/b")).getText());
        continueClick();
    }
}
