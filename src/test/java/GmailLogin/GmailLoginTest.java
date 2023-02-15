package GmailLogin;

import GmailPOM.GmailLoginPOM;
import org.testng.annotations.Test;

public class GmailLoginTest extends GmailLoginPOM {
    @Test
    public static void web() throws InterruptedException {
        Google();
        GmailLoginPage();
    }
}
