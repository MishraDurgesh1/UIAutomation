package OpenXYZTest;

import XYZBankPOM.AddCustomer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends AddCustomer {
    @Test
    public static void AddCustomer1() throws InterruptedException {
        XYZBank();
        waitBrowser(5000);
        AddCustomer();
        waitBrowser(5000);
        Customers();
        waitBrowser(5000);
        Assert.assertEquals("Harshit",driver.findElement(By.xpath("//td[@class=\"ng-binding\" and text()='Harshit']")).getText());
        Assert.assertEquals("Sharma",driver.findElement(By.xpath("//td[@class=\"ng-binding\" and text()='Sharma']")).getText());
        OpenAccount();
        waitBrowser(5000);
    }
}
