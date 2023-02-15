package OpenXYZTest;

import XYZBankPOM.OpenXYZBank;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenXYZBankTest extends OpenXYZBank {
    @Test
    public static void XYZBank1() {
        XYZBank();
        Assert.assertEquals("Add Customer",driver.findElement(By.xpath("//button[@ng-class=\"btnClass1\"]")).getText());
        Assert.assertEquals("Open Account",driver.findElement(By.xpath("//button[@ng-class=\"btnClass2\"]")).getText());
        Assert.assertEquals("Customers",driver.findElement(By.xpath("//button[@ng-class=\"btnClass3\"]")).getText());

    }
}

