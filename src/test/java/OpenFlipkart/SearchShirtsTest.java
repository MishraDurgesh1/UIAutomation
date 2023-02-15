package OpenFlipkart;

import FlipkartPOM.SearchShirts;
import org.testng.annotations.Test;

public class SearchShirtsTest extends SearchShirts {
    @Test
    public static void SearchMenShirt() {
        Flipkart();
        Shirts();
    }
}
