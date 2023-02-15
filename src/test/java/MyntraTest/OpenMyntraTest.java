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
        Assert.assertEquals("Rs. 298 To Rs. 6474",driver.findElement(By.xpath("(//div[@class=\"filter-summary-filter\"])[1]")).getText());
        Assert.assertEquals("Rs. 6474 To Rs. 12650",driver.findElement(By.xpath("(//div[@class=\"filter-summary-filter\"])[2]")).getText());
        Assert.assertEquals("Rs. 12650 To Rs. 18826",driver.findElement(By.xpath("(//div[@class=\"filter-summary-filter\"])[3]")).getText());
        Assert.assertEquals("CLEAR ALL",driver.findElement(By.xpath("//span[@class=\"header-clearAllBtn\"]")).getText());
    }
}
