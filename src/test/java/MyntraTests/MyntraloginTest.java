package MyntraTests;
import POM.Myntra.LoginMyntra;
import org.testng.annotations.Test;

public class MyntraloginTest extends LoginMyntra {
    @Test(priority = '1')
    public static void main(String[] args)
    {
        openMyntra("https://www.myntra.com/");
        searchClick();
        popularityClickNew();
    }
}