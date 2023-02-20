package FlipkartTest;

import POM.Flipkart.Newtab;
import org.testng.annotations.Test;

public class NewtabTest extends Newtab{
    @Test(priority = '3')
    public static void NewtabTest()
    {
        openflipkart("https://www.flipkart.com/");
        searchClick();
        searchAllProduct();
    }
}
