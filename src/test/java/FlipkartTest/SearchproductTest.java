package FlipkartTest;

import POM.Flipkart.Srearchproduct;
import org.testng.annotations.Test;

public class SearchproductTest extends Srearchproduct {
    @Test(priority = '2')
    public static void SearchproductTest()
    {
        openflipkart("https://www.flipkart.com/");
        searchClick();
    }
}
