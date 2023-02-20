package POM.Flipkart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Newtab extends Srearchproduct {

    public static void searchAllProduct() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"_30jeq3\"]"));
        for (WebElement product : list) {
            String jy = product.getText();
            String verma = jy.substring(1, 4);
            int jv = Integer.parseInt(verma);
            if (jv<=400)
            {
                product.click();
            }
        }
    }
}


