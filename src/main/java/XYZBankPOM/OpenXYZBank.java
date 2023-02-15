package XYZBankPOM;

import Base.Utility;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

public class OpenXYZBank extends Utility {
    public static void XYZBank() {
        openBrowser("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.findElement(By.xpath("//button[@ng-click=\"manager()\"]")).click();
    }
}