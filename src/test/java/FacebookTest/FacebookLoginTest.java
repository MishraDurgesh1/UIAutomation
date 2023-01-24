package FacebookTest;

import POM.FacebookUI.LoginFb;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLoginTest  extends LoginFb {

    @Test(priority = '1')
    public static void loginFacebook(){

        openFacebook();
        enterEmail("");
        enterPassword("");
        clickOnLogin();
        closeBrowser();
    }

    @Test(priority = '2')
    public static void verifyUrlFacebook() throws InterruptedException {
        openFacebook();
        getUrl();
        Assert.assertEquals("",getUrl());
        closeBrowser();
    }

    @Test(priority = '3')
    public static void verifyTitleFacebook(){

        openFacebook();
        getTitle();
        Assert.assertEquals("",getTitle());
        closeBrowser();
    }

}
