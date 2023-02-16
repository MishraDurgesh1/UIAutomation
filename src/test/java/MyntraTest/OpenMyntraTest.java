package MyntraTest;

import MyntraPOM.OpenMyntra;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenMyntraTest extends OpenMyntra {
    @Test
    public static void Myntra1() {
        Myntra();
        SearchShirt();
        ShirtsMens();
       Assert.assertEquals("Rs. 339 To Rs. 6504",driver.findElement(By.xpath("(//div[@class=\"filter-summary-filter\"])[1]")).getText());
       Assert.assertEquals("Rs. 6504 To Rs. 12669",driver.findElement(By.xpath("(//div[@class=\"filter-summary-filter\"])[2]")).getText());
       Assert.assertEquals("Rs. 12669 To Rs. 18834",driver.findElement(By.xpath("(//div[@class=\"filter-summary-filter\"])[3]")).getText());
       Assert.assertEquals("CLEAR ALL",driver.findElement(By.xpath("//span[@class=\"header-clearAllBtn\"]")).getText());
    }
}
