package MyntraPOM;

import Base.Utility;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.List;

public class OpenMyntra extends Utility {
    public static void Myntra() {
        openBrowser("https://www.myntra.com/");
        List<WebElement> allTag = driver.findElements(By.xpath("//div[@class=\"desktop-navContent\"]"));
        for (int i = 0; i < allTag.size(); i++) {
            System.out.println("TagName : " + allTag.get(i).getText());
        }
    }

    public static void SearchShirt() {
        int c=0;
        driver.findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("Shirt");
        List<WebElement> RelatedSearch = driver.findElements(By.xpath("//li[@class=\"desktop-suggestion null\"]"));
        for (WebElement elementcount : RelatedSearch) {
            c++;
        }
        System.out.println(c);
    }
    public static void ShirtsMens(){
        driver.findElement(By.xpath("//li[@data-index=\"1\"]")).click();
        List<WebElement> pricelist=driver.findElements(By.xpath("(//ul[@class='price-list']/li)/label/div"));
        int size=pricelist.size();
        for(int i=1;i<=size;i++)
        {
            WebElement cl=driver.findElement(By.xpath("(//ul[@class='price-list']/li)["+i+"]/label/div"));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cl.click();
        }
    }
}
