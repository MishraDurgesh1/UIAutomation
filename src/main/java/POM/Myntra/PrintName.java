package POM.Myntra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PrintName extends LoginMyntra {

    public static void sPrice() {
        List<WebElement> listPrice = driver.findElements(By.xpath("//span[@class=\"product-discountedPrice\"]"));

        try{
            for (int i = 0; i < listPrice.size(); i++) {

                String textPrice = listPrice.get(i).getText().substring(4,7);

                int price = Integer.parseInt(textPrice);
                if(price<=800){
                    System.out.print(price+" || ");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Hello Jyoti Check Your Code!!!");
        }
    }
}



